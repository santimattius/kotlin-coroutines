package coroutines

import endMsg
import header
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import someTime
import startMsg

fun main() {
    job()
}

private fun job() {
    runBlocking {
        header("Job")
        val job = launch {
            startMsg()
            delay(2_100)
            println("job...")
            endMsg()
        }
        println("Job: $job")

        //delay(4_000)
        println("isActive: ${job.isActive}")
        println("isCancelled: ${job.isCancelled}")
        println("isCompleted: ${job.isCompleted}")

        delay(someTime())
        println("Tarea cancelada o interrumpida")
        job.cancel()

        println("isActive: ${job.isActive}")
        println("isCancelled: ${job.isCancelled}")
        println("isCompleted: ${job.isCompleted}")
    }
}