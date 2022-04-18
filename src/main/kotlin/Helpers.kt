import java.util.Locale
import kotlin.random.Random

private const val SEPARATOR = "-------------------"

/**
 * Header console
 */
fun header(title: String) {
    println()
    println("$SEPARATOR $title $SEPARATOR")
    println()
}

/**
 * provide random time
 */
fun someTime(): Long = Random.nextLong(500, 2_000)

fun startMessage() {
    println("Start coroutine -${Thread.currentThread().name}-")
}

fun endMessage() {
    println("Coroutine -${Thread.currentThread().name}- finish")
}


infix fun Int.multi(that: Int): Int = this * that

fun convertCelsiusToFarenheit(celsius: Float): Float = ((celsius * 9) / 5) + 32

fun setFormat(temp: Float, degree: String = "C"): String = String.format(
    Locale.getDefault(),
    "%.1fº$degree", temp
)