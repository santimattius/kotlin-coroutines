package coroutines

import header
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import someTime

@DelicateCoroutinesApi
fun main() {
    suspendFun()
}

@DelicateCoroutinesApi
private fun suspendFun() {
    header("Suspend")
    Thread.sleep(someTime())
    GlobalScope.launch { delay(someTime()) }
}