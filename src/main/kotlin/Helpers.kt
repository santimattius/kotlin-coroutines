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

fun startMsg() {
    println("Comenzando corrutina -${Thread.currentThread().name}-")
}

fun endMsg() {
    println("Corrutina -${Thread.currentThread().name}- finalizada")
}


infix fun Int.multi(that: Int): Int = this * that

fun convertCelsToFahr(cels: Float): Float = ((cels * 9) / 5) + 32

fun setFormat(temp: Float, degree: String = "C"): String = String.format(
    Locale.getDefault(),
    "%.1fº$degree", temp
)