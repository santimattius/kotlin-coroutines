package flows

import getDataByFlowStatic
import getMatchResultsFlow
import header
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import setFormat

fun main() {
    multiFlow()
}

private fun multiFlow() {
    runBlocking {
        header("Zip $ Combine")
        getDataByFlowStatic()
            .map { setFormat(it) }
            .combine(getMatchResultsFlow()) { degrees, result ->
                //.zip(getMatchResultsFlow()){ degrees, result ->
                "$result with $degrees"
            }
            .collect { println(it) }
    }
}