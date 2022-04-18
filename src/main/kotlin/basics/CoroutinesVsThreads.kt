package basics

import header
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import someTime

fun main() {
    coroutinesVsThreads()
}


private fun coroutinesVsThreads() {
    header("Coroutine vs Threads")
    runBlocking {
        repeat((1..1_000_000).count()) {
            launch {
                delay(someTime())
                print("*")
            }
        }
    }

    /*(1..1_000_000).forEach {
        thread {
            Thread.sleep(someTime())
            println(˝"*")
        }
    }*/
}




