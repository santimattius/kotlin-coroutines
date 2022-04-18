package coroutines

import endMessage
import header
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import someTime
import startMessage

fun main() {
    executeLaunch()
}

private fun executeLaunch() {
    runBlocking {
        header("Launch")
        launch {
            startMessage()
            delay(someTime())
            println("launch...")
            endMessage()
        }
    }
}