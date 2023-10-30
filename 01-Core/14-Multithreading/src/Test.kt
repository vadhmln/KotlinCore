import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.math.BigInteger

fun main() {
    fun fibonacci(): Flow<BigInteger> = flow {
        var x = BigInteger.ZERO
        var y = BigInteger.ONE
        while (true) {
            emit(x)
            x = y.also {
                y += x
            }
        }
    }

    runBlocking {
        fibonacci().take(100).collect { println(it) }
    }
}




