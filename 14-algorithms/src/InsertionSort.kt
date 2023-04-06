fun main() {

    val list = arrayListOf(9, 3, 4, 10)
    println("Original: $list")
    list.insertionSort(true)
    println("Bubble sorted: $list")

}

fun <T : Comparable<T>> ArrayList<T>.insertionSort(showPasses: Boolean = false) {
    if (this.size < 2) return
    for (current in 1 until this.size) {            // проходим слева направо один раз
        for (shifting in (1..current).reversed()) { // обратный запуск от текущего индекса, чтобы можно было сдвинуть влево
            if (this[shifting] < this[shifting - 1]) {       // если элемент окажется на месте, разорвать внутренний цикл и начать со следующего элемента
                this.swapAt(shifting, shifting - 1)
            } else {
                break
            }
        }
        if (showPasses) println(this)
    }
}