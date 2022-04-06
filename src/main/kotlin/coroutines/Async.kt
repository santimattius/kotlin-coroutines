package coroutines

import endMsg
import header
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import someTime
import startMsg

fun main() {
    executeAsync()
}

private fun executeAsync() {
    runBlocking {
        header("Async")
        val result = async {
            startMsg()
            delay(someTime())
            println("async...")
            endMsg()
            1
        }
        println("Result: ${result.await()}")
    }
}