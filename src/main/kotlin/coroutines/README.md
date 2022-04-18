# Coroutines

## Suspend Functions

Suspend function is a function that could be started, paused, and resume. One of the most important points to remember
about the suspend functions is that they are only allowed to be called from a coroutine or another suspend function. An
example is given below, in which we have tried to call the delay() function from outside of the coroutine.

## RunBlocking

Runs a new coroutine and blocks the current thread until its completion. This function should not be used from a
coroutine. It is designed to bridge regular blocking code to libraries that are written in suspending style, to be used
in main functions and in tests.

## Jobs

A background job. Conceptually, a job is a cancellable thing with a life-cycle that culminates in its completion.

Jobs can be arranged into parent-child hierarchies where cancellation of a parent leads to immediate cancellation of all
its children recursively. Failure of a child with an exception other than CancellationException immediately cancels its
parent and, consequently, all its other children. This behavior can be customized using SupervisorJob.

The most basic instances of Job interface are created like this:

**Coroutine job** is created with launch coroutine builder. It runs a specified block of code and completes on
completion of this block.

**CompletableJob** is created with a Job() factory function. It is completed by calling CompletableJob.complete.

Conceptually, an execution of a job does not produce a result value. Jobs are launched solely for their side-effects.
See Deferred interface for a job that produces a result.

## Global Scope

A global CoroutineScope not bound to any job. Global scope is used to launch top-level coroutines which are operating on
the whole application lifetime and are not cancelled prematurely.

Active coroutines launched in GlobalScope do not keep the process alive. They are like daemon threads.

This is a delicate API. It is easy to accidentally create resource or memory leaks when GlobalScope is used. A coroutine
launched in GlobalScope is not subject to the principle of structured concurrency, so if it hangs or gets delayed due to
a problem (e.g. due to a slow network), it will stay working and consuming resources.

## Async

Creates a coroutine and returns its future result as an implementation of Deferred. The running coroutine is cancelled
when the resulting deferred is cancelled. The resulting coroutine has a key difference compared with similar primitives
in other languages and frameworks: it cancels the parent job (or outer scope) on failure to enforce structured
concurrency paradigm. To change that behaviour, supervising parent (SupervisorJob or supervisorScope) can be used.

Coroutine context is inherited from a CoroutineScope, additional context elements can be specified with context
argument. If the context does not have any dispatcher nor any other ContinuationInterceptor, then Dispatchers.Default is
used. The parent job is inherited from a CoroutineScope as well, but it can also be overridden with corresponding
context element.

By default, the coroutine is immediately scheduled for execution. Other options can be specified via start parameter.
See CoroutineStart for details. An optional start parameter can be set to CoroutineStart.LAZY to start coroutine lazily.
In this case, the resulting Deferred is created in new state. It can be explicitly started with start function and will
be started implicitly on the first invocation of join, await or awaitAll.

## Deferred

Deferred value is a non-blocking cancellable future — it is a Job with a result.

It is created with the async coroutine builder or via the constructor of CompletableDeferred class. It is in active
state while the value is being computed.

Deferred has the same state machine as the Job with additional convenience methods to retrieve the successful or failed
result of the computation that was carried out. The result of the deferred is available when it is completed and can be
retrieved by await method, which throws an exception if the deferred had failed. Note that a cancelled deferred is also
considered as completed. The corresponding exception can be retrieved via getCompletionExceptionOrNull from a completed
instance of deferred.

Usually, a deferred value is created in active state (it is created and started). However, the async coroutine builder
has an optional start parameter that creates a deferred value in new state when this parameter is set to
CoroutineStart.LAZY. Such a deferred can be be made active by invoking start, join, or await.

A deferred value is a Job. A job in the coroutineContext of async builder represents the coroutine itself.

All functions on this interface and on all interfaces derived from it are thread-safe and can be safely invoked from
concurrent coroutines without external synchronization.

Deferred interface and all its derived interfaces are not stable for inheritance in 3rd party libraries, as new methods
might be added to this interface in the future, but is stable for use.






