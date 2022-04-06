package coroutines

import endMsg
import header
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import someTime
import startMsg

@DelicateCoroutinesApi
fun main() {
    globalScope()
}

@DelicateCoroutinesApi
private fun globalScope() {
    header("Global Scope")
    GlobalScope.launch {
        startMsg()
        delay(someTime())
        println("Mi corrutina")
        endMsg()
    }
}