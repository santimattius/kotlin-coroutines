package flows

import getDataByFlow
import header
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

fun main() {
    terminalFlowOperators()
}

fun terminalFlowOperators() {
    runBlocking {
        header("Operadores Flow Terminales")
        header("List")
        val list = getDataByFlow()
        //.toList()
        println("List: $list")

        header("Single")
        val single = getDataByFlow()
        //.take(1)
        //.single()
        println("Single: $single")

        header("First")
        val first = getDataByFlow()
        //.first()
        println("First: $first")

        header("Last")
        val last = getDataByFlow()
        //.last()
        println("First: $last")

        header("Reduce")
        val saving = getDataByFlow()
            .reduce { accumulator, value ->
                println("Accumulator: $accumulator")
                println("Value: $value")
                println("Current saving: ${accumulator + value}")
                accumulator + value
            }
        println("Saving: $saving")

        header("Fold")
        val totalSaving = getDataByFlow()
            .fold(saving) { acc, value ->
                println("Accumulator: $acc")
                println("Value: $value")
                println("Current saving: ${acc + value}")
                acc + value
            }
        println("TotalSaving: $totalSaving")
    }
}