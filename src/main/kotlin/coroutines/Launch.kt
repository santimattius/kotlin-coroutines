package coroutines

import endMsg
import header
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import someTime
import startMsg

fun main() {
    executeLaunch()
}

private fun executeLaunch() {
    runBlocking {
        header("Launch")
        launch {
            startMsg()
            delay(someTime())
            println("launch...")
            endMsg()
        }
    }
}