import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    coroutinesVsThreads()
}


private fun coroutinesVsThreads() {
    header("Corrutinas vs Threads")
    runBlocking {
        repeat((1..1_000_000).count()) {
            launch {
                delay(someTime())
                print("*")
            }
        }
    }

    /*(1..1_000_000).forEach {
        thread {
            Thread.sleep(someTime())
            println(˝"*")
        }
    }*/
}




