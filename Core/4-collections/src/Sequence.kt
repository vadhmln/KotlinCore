import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

fun main() {

    // Создание последовательностей
    // С помощью элементов - функция sequenceOf()
    val sequenceNumbers = sequenceOf(1, 2, 3, 4)

    val filteredSequenceNumbers = sequenceNumbers.map { it * it }.filter { it > 3 }

    println("Цифры до преобразования и фильтрации: ${sequenceNumbers.toList()} \n " +
            "Цифры после: ${filteredSequenceNumbers.toList()}")

    val listNumbers = listOf(1, 2, 3, 4).asFlow()

    listNumbers.map { it * it }.filter { it > 3 }
}
