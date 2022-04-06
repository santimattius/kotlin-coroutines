package channels

import header
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

@ExperimentalCoroutinesApi
fun main() {
    executeProduce()
}


@ExperimentalCoroutinesApi
private fun executeProduce() = runBlocking {
    header("Produce")
    val names = produceNames()
    names.consumeEach { println(it) }
}

@ExperimentalCoroutinesApi
private fun CoroutineScope.produceNames(): ReceiveChannel<String> = produce {
    (1..5).forEach { send("name$it") }
}