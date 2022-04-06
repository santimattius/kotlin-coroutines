package flows

import getDataByFlowStatic
import header
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import setFormat
import kotlin.system.measureTimeMillis

fun main() {
  bufferFlow()
}

private fun bufferFlow() {
    runBlocking {
        header("Buffer para Flow")
        val time = measureTimeMillis {
            getDataByFlowStatic()
                .map { setFormat(it) }
                .buffer()
                .collect {
                    delay(500)
                    println(it)
                }
        }
        println("Time: ${time}ms")
    }
}
