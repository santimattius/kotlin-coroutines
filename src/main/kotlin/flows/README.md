# Flows

In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return
only a single value. For example, you can use a flow to receive live updates from a database.

Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can
be computed asynchronously. The emitted values must be of the same type. For example, a Flow<Int> is a flow that emits
integer values.

A flow is very similar to an Iterator that produces a sequence of values, but it uses suspend functions to produce and
consume values asynchronously. This means, for example, that the flow can safely make a network request to produce the
next value without blocking the main thread.

There are three entities involved in streams of data:

- A producer produces data that is added to the stream. Thanks to coroutines, flows can also produce data
  asynchronously.
- (Optional) Intermediaries can modify each value emitted into the stream or the stream itself.
- A consumer consumes the values from the stream.

<p align="center">
  <img width="500" src="https://github.com/santimattius/kotlin-coroutines/blob/master/src/main/resources/flow-entities.png?raw=true" alt="flows"/>
</p>

## Buffer Flow

Buffers flow emissions via channel of a specified capacity and runs collector in a separate coroutine.

Normally, flows are sequential. It means that the code of all operators is executed in the same coroutine. For example,
consider the following code using onEach and collect operators:

```kotlin
flowOf("A", "B", "C")
    .onEach { println("1$it") }
    .collect { println("2$it") }
```

It is going to be executed in the following order by the coroutine Q that calls this code:

`Q : -->-- [1A] -- [2A] -- [1B] -- [2B] -- [1C] -- [2C] -->--`

## Cancel

The launch function returns a Job that can be used to cancel the running coroutine:

```kotlin
fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion 
    println("main: Now I can quit.")
}
```

As soon as main invokes job.cancel, we don't see any output from the other coroutine because it was cancelled. There is
also a Job extension function cancelAndJoin that combines cancel and join invocations.

## Completion

When flow collection completes (normally or exceptionally) it may need to execute an action. As you may have already
noticed, it can be done in two ways: imperative or declarative. Imperative finally block In addition to try/catch, a
collector can also use a finally block to execute an action upon collect completion.

```kotlin
fun simple(): Flow<Int> = (1..3).asFlow()

fun main() = runBlocking<Unit> {
    try {
        simple().collect { value -> println(value) }
    } finally {
        println("Done")
    }
}    
```

## Cold Flow

Flows are cold streams similar to sequences — the code inside a flow builder does not run until the flow is collected.
This becomes clear in the following example:

```kotlin

fun simple(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("Calling simple function...")
    val flow = simple()
    println("Calling collect...")
    flow.collect { value -> println(value) }
    println("Calling collect again...")
    flow.collect { value -> println(value) }
}
```

This is a key reason the simple function (which returns a flow) is not marked with suspend modifier. By itself, simple()
call returns quickly and does not wait for anything. The flow starts every time it is collected, that is why we see "
Flow started" when we call collect again.

## Conflation Flow

When a flow represents partial results of the operation or operation status updates, it may not be necessary to process
each value, but instead, only most recent ones. In this case, the conflate operator can be used to skip intermediate
values when a collector is too slow to process them. Building on the previous example:

```kotlin
val time = measureTimeMillis {
    simple()
        .conflate() // conflate emissions, don't process each one
        .collect { value ->
            delay(300) // pretend we are processing it for 300 ms
            println(value)
        }
}
println("Collected in $time ms")
```

## Flat Flow

Flows represent asynchronously received sequences of values, so it is quite easy to get in a situation where each value
triggers a request for another sequence of values. For example, we can have the following function that returns a flow
of two strings 500 ms apart:

```kotlin
fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(500) // wait 500 ms emit("$i: Second")
}
```

Now if we have a flow of three integers and call requestFlow for each of them like this:

```kotlin
(1..3).asFlow().map { requestFlow(it) }
```

Then we end up with a flow of flows (Flow<Flow<String>>) that needs to be flattened into a single flow for further
processing. Collections and sequences have flatten and flatMap operators for this. However, due to the asynchronous
nature of flows they call for different modes of flattening, as such, there is a family of flattening operators on
flows.

## Exception

Flow collection can complete with an exception when an emitter or code inside the operators throw an exception. There
are several ways to handle these exceptions.

### Collector try and catch

A collector can use Kotlin's try/catch block to handle exceptions:

```kotlin
fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    try {
        simple().collect { value ->
            println(value)
            check(value <= 1) { "Collected $value" }
        }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}  
```

### Exception transparency

But how can code of the emitter encapsulate its exception handling behavior?

Flows must be transparent to exceptions and it is a violation of the exception transparency to emit values in the flow {
... } builder from inside of a try/catch block. This guarantees that a collector throwing an exception can always catch
it using try/catch as in the previous example.

The emitter can use a catch operator that preserves this exception transparency and allows encapsulation of its
exception handling. The body of the catch operator can analyze an exception and react to it in different ways depending
on which exception was caught:

- Exceptions can be rethrown using throw.
- Exceptions can be turned into emission of values using emit from the body of catch.
- Exceptions can be ignored, logged, or processed by some other code.

For example, let us emit the text on catching an exception:

```kotlin
simple()
    .catch { e -> emit("Caught $e") } // emit on exception
    .collect { value -> println(value) }
```

## Operators

Flows can be transformed with operators, just as you would with collections and sequences. Intermediate operators are
applied to an upstream flow and return a downstream flow. These operators are cold, just like flows are. A call to such
an operator is not a suspending function itself. It works quickly, returning the definition of a new transformed flow.

The basic operators have familiar names like map and filter. The important difference to sequences is that blocks of
code inside these operators can call suspending functions.

For example, a flow of incoming requests can be mapped to the results with the map operator, even when performing a
request is a long-running operation that is implemented by a suspending function:

```kotlin
suspend fun performRequest(request: Int): String {
    delay(1000) // imitate long-running asynchronous work
    return "response $request"
}

fun main() = runBlocking<Unit> {
    (1..3).asFlow() // a flow of requests
        .map { request -> performRequest(request) }
        .collect { response -> println(response) }
}
```

[See more](https://kotlinlang.org/docs/flow.html#intermediate-flow-operators)

## MultiFlow

There are lots of ways to compose multiple flows.

Show all operators [here](https://kotlinlang.org/docs/flow.html#composing-multiple-flows)

## Terminal Operator

Terminal operators on flows are suspending functions that start a collection of the flow. The collect operator is the
most basic one, but there are other terminal operators, which can make it easier:

- Conversion to various collections like toList and toSet.
- Operators to get the first value and to ensure that a flow emits a single value.
- Reducing a flow to a value with reduce and fold.

For example:

```kotlin
val sum = (1..5).asFlow()
    .map { it * it } // squares of numbers from 1 to 5                           
    .reduce { a, b -> a + b } // sum them (terminal operator)
println(sum)
```
