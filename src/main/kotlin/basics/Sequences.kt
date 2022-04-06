package basics

import header
import someTime
import kotlin.random.Random

fun main() {
    header("Sequences")
    sequences()
}

fun sequences() {
    getData().forEach { println("$it") }
}

private fun getData(): Sequence<Float> {
    return sequence {
        (1..5).forEach {
            println("loading...")
            Thread.sleep(someTime())
            yield(20 + it + Random.nextFloat())
        }
    }
}