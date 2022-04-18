package coroutines

import endMessage
import header
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import multi
import someTime
import startMessage

fun main() {
    executeDeferred()
}

private fun executeDeferred() {
    runBlocking {
        header("Deferred")
        val deferred = async {
            startMessage()
            delay(someTime())
            println("deferred...")
            endMessage()
            5 multi 2
            "Hello"
        }
        println("Deferred: $deferred")
        println("Deferred.await: ${deferred.await()}")

        val result = async {
            3 multi 3
        }.await()
        println("Result: $result")
    }
}