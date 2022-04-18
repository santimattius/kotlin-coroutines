package coroutines

import endMessage
import header
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import someTime
import startMessage

fun main() {
    executeRunBlocking()
}

private fun executeRunBlocking() {
    header("RunBlocking")
    runBlocking {
        startMessage()
        delay(someTime())
        println("runBlocking...")
        endMessage()
    }
}