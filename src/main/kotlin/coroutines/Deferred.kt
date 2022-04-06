package coroutines

import endMsg
import header
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import multi
import someTime
import startMsg

fun main() {
    executeDeferred()
}

private fun executeDeferred() {
    runBlocking {
        header("Deferred")
        val deferred = async {
            startMsg()
            delay(someTime())
            println("deferred...")
            endMsg()
            5 multi 2
            "Hola"
        }
        println("Deferred: $deferred")
        println("Valor del Deferred.await: ${deferred.await()}")

        val result = async {
            3 multi 3
        }.await()
        println("Result: $result")
    }
}