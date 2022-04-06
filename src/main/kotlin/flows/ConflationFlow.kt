package flows

import getMatchResultsFlow
import header
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    conflationFlow()
}

private fun conflationFlow() {
    runBlocking {
        header("Fusión")
        val time = measureTimeMillis {
            getMatchResultsFlow()
                .conflate() //2558ms
                //.buffer() //4820ms
                //.collectLatest {//2597ms
                .collect {  //7087ms
                    delay(100)
                    println(it)
                }
        }
        println("Time: ${time}ms")
    }
}