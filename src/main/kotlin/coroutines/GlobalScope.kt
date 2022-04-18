package coroutines

import endMessage
import header
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import someTime
import startMessage

@DelicateCoroutinesApi
fun main() {
    globalScope()
}

@DelicateCoroutinesApi
private fun globalScope() {
    header("Global Scope")
    GlobalScope.launch {
        startMessage()
        delay(someTime())
        println("My Coroutine")
        endMessage()
    }
}