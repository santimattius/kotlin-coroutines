package flows

import convertCelsToFahr
import getDataByFlow
import header
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking
import setFormat

fun main() {
    flowOperators()
}

private fun flowOperators() {
    runBlocking {
        header("Operadores Flow Intermediarios")
        header("Map")
        getDataByFlow()
            .map {
                //setFormat(it)
                setFormat(convertCelsToFahr(it), "F")
            }
        //.collect { println(it) }

        header("Filter")
        getDataByFlow()
            .filter {
                it > 23
            }
            .map {
                setFormat(it)
            }
        //.collect { println(it) }

        header("Transform")
        getDataByFlow()
            .transform {
                emit(setFormat(it))
                emit(setFormat(convertCelsToFahr(it), "F"))
            }
        //.collect { println(it) }

        header("Take")
        getDataByFlow()
            .take(3)
            .map { setFormat(it) }
            .collect { println(it) }
    }
}