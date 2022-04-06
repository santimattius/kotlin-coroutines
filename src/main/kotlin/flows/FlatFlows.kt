package flows

import getCitiesFlow
import getDataToFlatFlow
import header
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import setFormat

@FlowPreview
fun main() {
    flatFlows()
}

@FlowPreview
private fun flatFlows() {
    runBlocking {
        header("Flujos de aplanamiento")

        header("FlatMapConcat")
        getCitiesFlow()
            .flatMapConcat { city -> //Flow<Flow<TYPE>>
                getDataToFlatFlow(city)
            }
            .map { setFormat(it) }
            .collect { println(it) }

        header("FlatMapMerge")
        getCitiesFlow()
            .flatMapMerge { city -> //Flow<Flow<TYPE>>
                getDataToFlatFlow(city)
            }
            .map { setFormat(it) }
            .collect { println(it) }
    }
}