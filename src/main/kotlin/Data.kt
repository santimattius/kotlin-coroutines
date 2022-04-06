import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

fun getDataToFlatFlow(city: String): Flow<Float> = flow {
    (1..3).forEach {
        println("Temperatura de ayer en $city...")
        emit(Random.nextInt(10, 30).toFloat())

        println("Temperatura actual en $city:")
        delay(100)
        emit(20 + it + Random.nextFloat())
    }
}

fun getCitiesFlow(): Flow<String> = flow {
    listOf("Santander", "CDMX", "Lima")
        .forEach { city ->
            println("\nConsultando ciudad...")
            delay(1_000)
            emit(city)
        }
}

fun getMatchResultsFlow(): Flow<String> {
    return flow {
        var homeTeam = 0
        var awayTeam = 0
        (0..45).forEach {
            println("minuto: $it")
            delay(50)
            homeTeam += Random.nextInt(0, 21) / 20
            awayTeam += Random.nextInt(0, 21) / 20
            emit("$homeTeam-$awayTeam")

            if (homeTeam == 2 || awayTeam == 2) throw Exception("Habían acordado 1 y 1 :v")
        }
    }
}

fun getDataByFlowStatic(): Flow<Float> {
    return flow {
        (1..5).forEach {
            println("procesando datos...")
            delay(300)
            emit(20 + it + Random.nextFloat())
        }
    }
}

fun getDataByFlow(): Flow<Float> {
    return flow {
        (1..5).forEach {
            println("procesando datos...")
            delay(300)
            emit(20 + it + Random.nextFloat())
        }
    }
}