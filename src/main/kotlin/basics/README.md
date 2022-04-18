# Basics

## Coroutine vs Threads

Launch 1 millon of thread cause exception

```kotlin
(1..1_000_000).forEach { _ ->
    thread {
        Thread.sleep(someTime())
        println("*")
    }
}
```

using coroutines

```kotlin
runBlocking {
    repeat((1..1_000_000).count()) {
        launch {
            delay(someTime())
            print("*")
        }
    }
}
```

## Sequences

Along with collections, the Kotlin standard library contains another container type – sequences (Sequence<T>). Sequences
offer the same functions as Iterable but implement another approach to multi-step collection processing.

When the processing of an Iterable includes multiple steps, they are executed eagerly: each processing step completes
and returns its result – an intermediate collection. The following step executes on this collection. In turn, multi-step
processing of sequences is executed lazily when possible: actual computing happens only when the result of the whole
processing chain is requested.

The order of operations execution is different as well: Sequence performs all the processing steps one-by-one for every
single element. In turn, Iterable completes each step for the whole collection and then proceeds to the next step.

So, the sequences let you avoid building results of intermediate steps, therefore improving the performance of the whole
collection processing chain. However, the lazy nature of sequences adds some overhead which may be significant when
processing smaller collections or doing simpler computations. Hence, you should consider both Sequence and Iterable and
decide which one is better for your case.

[See more](https://kotlinlang.org/docs/sequences.html)