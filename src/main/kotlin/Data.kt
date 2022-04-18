import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

fun getDataToFlatFlow(city: String): Flow<Float> = flow {
    (1..3).forEach {
        println("yesterday's temperature in $city...")
        emit(Random.nextInt(10, 30).toFloat())

        println("Current temperature in $city:")
        delay(100)
        emit(20 + it + Random.nextFloat())
    }
}

fun getCitiesFlow(): Flow<String> = flow {
    listOf("Madrid", "New York", "London")
        .forEach { city ->
            println("\nwaiting...")
            delay(1_000)
            emit(city)
        }
}

fun getMatchResultsFlow(): Flow<String> {
    return flow {
        var homeTeam = 0
        var awayTeam = 0
        (0..45).forEach {
            println("min: $it")
            delay(50)
            homeTeam += Random.nextInt(0, 21) / 20
            awayTeam += Random.nextInt(0, 21) / 20
            emit("$homeTeam-$awayTeam")

            if (homeTeam == 2 || awayTeam == 2) throw Exception("They had agreed 1 and 1 :v")
        }
    }
}

fun getDataByFlowStatic(): Flow<Float> {
    return flow {
        (1..5).forEach {
            println("loading...")
            delay(300)
            emit(20 + it + Random.nextFloat())
        }
    }
}

fun getDataByFlow(): Flow<Float> {
    return flow {
        (1..5).forEach {
            println("loading...")
            delay(300)
            emit(20 + it + Random.nextFloat())
        }
    }
}