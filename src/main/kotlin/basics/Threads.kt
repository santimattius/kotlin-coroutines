package basics

import header
import someTime
import kotlin.concurrent.thread

fun main() {
    threads()
}

private fun threads() {
    header("Threads")
    println("Thread ${multiThread(2, 3)}")
    multiThreadLambda(2, 3) {
        println("Thread+Lambda $it")
    }
}

private fun multiThread(x: Int, y: Int): Int {
    var result = 0

    thread {
        Thread.sleep(someTime())
        result = x * y
    }

    Thread.sleep(2_100)
    return result
}

fun multiThreadLambda(x: Int, y: Int, callback: (result: Int) -> Unit) {
    var result: Int

    thread {
        Thread.sleep(someTime())
        result = x * y
        callback(result)
    }
}