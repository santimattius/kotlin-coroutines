package flows

import getDataByFlow
import header
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import someTime

fun main() {
    cancelFlow()
}

private fun cancelFlow() {
    runBlocking {
        header("Cancelar flow")
        val job = launch {
            getDataByFlow().collect { println(it) }
        }
        delay(someTime() * 2)
        job.cancel()
    }
}