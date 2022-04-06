package flows

import getCitiesFlow
import getDataByFlowStatic
import getMatchResultsFlow
import header
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

fun main() {
    completions()
}

private fun completions() {
    runBlocking {
        header("Fin de un Flujo(onCompletion)")
        getCitiesFlow()
            .onCompletion { println("Quitar el progressBar...") }
        //.collect { println(it) }
        println()

        getMatchResultsFlow()
            .onCompletion { println("Mostrar las estadísticas...") }
            .catch { emit("Error: $this") }
            .collect { println(it) }

        header("Cancelar Flow")
        getDataByFlowStatic()
            .onCompletion { println("Ya no le interesa al usuario...") }
            .cancellable()
            .collect {
                if (it > 29.5f) cancel()
                println(it)
            }
    }
}