package coroutines

import endMessage
import header
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import someTime
import startMessage

fun main() {
    executeAsync()
}

private fun executeAsync() {
    runBlocking {
        header("Async")
        val result = async {
            startMessage()
            delay(someTime())
            println("async...")
            endMessage()
            1
        }
        println("Result: ${result.await()}")
    }
}