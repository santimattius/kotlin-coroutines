package flows

import getDataByFlow
import header
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import someTime

fun main() {
    coldFlow()
}

private fun coldFlow() {
    header("Flows are Cold")
    runBlocking {
        val dataFlow = getDataByFlow()
        println("waiting...")
        delay(someTime())
        dataFlow.collect { println(it) }
    }
}