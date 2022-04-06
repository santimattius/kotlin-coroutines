package coroutines

import endMsg
import header
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import someTime
import startMsg

fun main() {
    executeRunBlocking()
}

private fun executeRunBlocking() {
    header("RunBlocking")
    runBlocking {
        startMsg()
        delay(someTime())
        println("runBlocking...")
        endMsg()
    }
}