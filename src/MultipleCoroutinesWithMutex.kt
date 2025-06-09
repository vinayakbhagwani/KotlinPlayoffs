import kotlin.coroutines.*
import kotlin.coroutines.sync.Mutex
import kotlin.coroutines.sync.withLock

fun main() {
    runBlocking {
        val mutex = Mutex()
        var counter = 0

        val jobs = List(1000) {
            launch {
                repeat(1000) {
                    mutex.withLock {
                        counter++
                    }
                }
            }
        }

        jobs.forEach { it.join() }

        println("Final Counter: $counter")
    }
}