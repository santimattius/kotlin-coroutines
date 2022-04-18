# kotlin-coroutines

Coroutine note project, include example, reference to documentation.

Topics:

- Coroutine
- Thread
- Flows
- Channels
- Sequence

## Coroutines

Asynchronous or non-blocking programming is an important part of the development landscape. When creating server-side,
desktop, or mobile applications, it's important to provide an experience that is not only fluid from the user's
perspective, but also scalable when needed. Kotlin solves this problem in a flexible way by providing coroutine support
at the language level and delegating most of the functionality to libraries. In addition to opening the doors to
asynchronous programming, coroutines also provide a wealth of other possibilities, such as concurrency and actors.

## How to start

New to Kotlin? Take a look at
the [Getting started page](https://kotlinlang.org/docs/coroutines-overview.html#how-to-start).

### Documentation

- [Coroutines guide](https://kotlinlang.org/docs/coroutines-guide.html)
- [Basics](https://kotlinlang.org/docs/coroutines-basics.html)
- [Channels](https://kotlinlang.org/docs/channels.html)
- [Coroutine context and dispatchers](https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html)
- [Shared mutable state and concurrency](https://kotlinlang.org/docs/shared-mutable-state-and-concurrency.html)
- [Asynchronous flow](https://kotlinlang.org/docs/flow.html)

### Tutorials

- [Asynchronous programming techniques](https://kotlinlang.org/docs/async-programming.html)
- [Introduction to coroutines and channels](https://play.kotlinlang.org/hands-on/Introduction%20to%20Coroutines%20and%20Channels/01_Introduction)
- [Debug coroutines using IntelliJ IDEA](https://kotlinlang.org/docs/debug-coroutines-with-idea.html)
- [Debug Kotlin Flow using IntelliJ IDEA – tutorial](https://kotlinlang.org/docs/debug-flow-with-idea.html)

## Sample projects

- [kotlinx.coroutines examples and sources](https://github.com/Kotlin/coroutines-examples/tree/master/examples)
- [KotlinConf app](https://github.com/JetBrains/kotlinconf-app)
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html#top)

Check full documentation [here](https://kotlinlang.org/docs/coroutines-overview.html#documentation)

# References

## Talks

- [KotlinConf 2017 - Introduction to Coroutines by Roman Elizarov](https://www.youtube.com/watch?v=_hfBv0a09Jc)
- [KotlinConf 2018 - Kotlin Coroutines in Practice by Roman Elizarov](https://www.youtube.com/watch?v=a3agLJQ6vt8)
- [KotlinConf 2018 - Coroutines and Reactive Programming - Friends or Foes? by Konrad Kamiński](https://www.youtube.com/watch?v=yoLh4sd1CWI)
- [KotlinConf 2017 - Deep Dive into Coroutines on JVM by Roman Elizarov](https://www.youtube.com/watch?v=YrrUCSi72E8)
- [KotlinConf 2018 - Exploring Coroutines in Kotlin by Venkat Subramaniam](https://www.youtube.com/watch?v=jT2gHPQ4Z1Q)
- [KotlinConf 2019: Asynchronous Data Streams with Kotlin Flow by Roman Elizarov](https://www.youtube.com/watch?v=tYcqn48SMT8)
- [KotlinConf 2019: Migrating a Library from RxJava To Coroutines by Mike Nakhimovich & Yiğit Boyar](https://www.youtube.com/watch?v=raWdIwsDe-g)
- [🔹Flows en Kotlin: Todo lo que necesitas saber](https://www.youtube.com/watch?v=IGcxs3A4IgY)
- [👉 Usando Flow en un proyecto Android 👾](https://www.youtube.com/watch?v=ALEq99u614I&list=RDCMUCV31octs5hft6bZmokUgQlA&index=21)
- [Kotlin Flows and Channels for Android • Ryan Pierce • GOTO 2020](https://www.youtube.com/watch?v=xch4aw7hNcY)
- [KotlinConf 2019: Coroutines! Gotta catch 'em all! by Florina Muntenescu & Manuel Vivo](https://www.youtube.com/watch?v=w0kfnydnFWI)

## Documentation

- [Kotlin flows on Android](https://developer.android.com/kotlin/flow)

## Posts

### Roman Elizarov (Project Lead for the Kotlin Programming Language)

- [Medium profile](https://elizarov.medium.com/)
- [Kotlin Coroutines, a deeper look](https://elizarov.medium.com/kotlin-coroutines-a-deeper-look-180536305c3f)
- [Futures, cancellation and coroutines](https://elizarov.medium.com/futures-cancellation-and-coroutines-b5ce9c3ede3a)
- [Blocking threads, suspending coroutines](https://elizarov.medium.com/blocking-threads-suspending-coroutines-d33e11bf4761)
- [Coroutine Context and Scope](https://elizarov.medium.com/coroutine-context-and-scope-c8b255d59055)
- [Cold flows, hot channels](https://elizarov.medium.com/cold-flows-hot-channels-d74769805f9)
- [Simple design of Kotlin Flow](https://elizarov.medium.com/simple-design-of-kotlin-flow-4725e7398c4c)
- [Kotlin Flows and Coroutines](https://elizarov.medium.com/kotlin-flows-and-coroutines-256260fb3bdb)
- [Execution context of Kotlin Flows](https://elizarov.medium.com/execution-context-of-kotlin-flows-b8c151c9309b)
- [Reactive Streams and Kotlin Flows](https://elizarov.medium.com/reactive-streams-and-kotlin-flows-bfd12772cda4)
- [Exceptions in Kotlin Flows](https://elizarov.medium.com/exceptions-in-kotlin-flows-b59643c940fb)
- [Callbacks and Kotlin Flows](https://elizarov.medium.com/callbacks-and-kotlin-flows-2b53aa2525cf)

### Mindoks

- [What is Flow in Kotlin and how to use it in Android Project?](https://blog.mindorks.com/what-is-flow-in-kotlin-and-how-to-use-it-in-android-project)
- [Understanding Terminal Operators in Kotlin Flow](https://blog.mindorks.com/terminal-operators-in-kotlin-flow)
- [Creating Flow Using Flow Builder in Kotlin](https://blog.mindorks.com/creating-flow-using-flow-builder-in-kotlin)
- [Learn Kotlin Flow in Android by Examples](https://github.com/MindorksOpenSource/Kotlin-Flow-Android-Examples)
- [Exception Handling in Kotlin Flow](https://blog.mindorks.com/exception-handling-in-kotlin-flow)
- [Kotlin Flow Zip Operator](https://blog.mindorks.com/kotlin-flow-zip-operator-parallel-multiple-network-calls)
- [Kotlin Flow Retry Operator with Exponential Backoff Delay](https://blog.mindorks.com/kotlin-flow-retry-operator-with-exponential-backoff-delay)

