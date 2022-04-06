package flows

import getMatchResultsFlow
import header
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking

fun main() {
    flowExceptions()
}

private fun flowExceptions() {
    runBlocking {
        header("Control de errores")
        header("Try/Catch")
        /*try {
            getMatchResultsFlow()
                .collect {
                    println(it)
                    if (it.contains("2")) throw Exception("Habían acordado 1-1 :v")
                }
        } catch (e: Exception) {
            e.printStackTrace()
        }*/

        header("Transparencia")
        getMatchResultsFlow()
            .catch {
                emit("Error: $this")
            }
            .collect {
                println(it)
                if (!it.contains("-")) println("Notifica al programador...")
            }
    }
}