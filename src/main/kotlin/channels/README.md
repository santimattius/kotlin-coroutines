# Channels

Deferred values provide a convenient way to transfer a single value between coroutines. Channels provide a way to
transfer a stream of values.

## Channel basics

A Channel is conceptually very similar to BlockingQueue. One key difference is that instead of a blocking put operation
it has a suspending send, and instead of a blocking take operation it has a suspending receive.

## Producers

The pattern where a coroutine is producing a sequence of elements is quite common. This is a part of producer-consumer
pattern that is often found in concurrent code. You could abstract such a producer into a function that takes channel as
its parameter, but this goes contrary to common sense that results must be returned from functions.

There is a convenient coroutine builder named produce that makes it easy to do it right on producer side, and an
extension function consumeEach, that replaces a for loop on the consumer side:

```kotlin
@ExperimentalCoroutinesApi
private fun executeProduce() = runBlocking {
    header("Produce")
    val names = produceNames()
    names.consumeEach { println(it) }
}

@ExperimentalCoroutinesApi
private fun CoroutineScope.produceNames(): ReceiveChannel<String> = produce {
    (1..5).forEach { send("name$it") }
}
```

[See more](https://kotlinlang.org/docs/channels.html)