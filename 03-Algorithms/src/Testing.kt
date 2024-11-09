fun main() {
    val list = mutableListOf(9, 8, 7, 6)
//    list.bSortTest()
    println(list)

}

//fun <T: Comparable<T>> MutableList<T>.bSortTest() {
//    this.forEachIndexed { index, value ->
//        if (this[index] > this[index + 1]) {
//            this[index] = this[index + 1].also { this[index + 1] = this[index]  }
//        }
//    }
////    for (i in this.lastIndex downTo 1) {
////        for (current in 0 until i) {
////            if (this[current] > this[current + 1]) {
////                val temp = this[current]
////                this[current] = this[current + 1]
////                this[current + 1] = temp
////            }
////        }
////    }
//}

fun <T : Comparable<T>> List<T>.bSortFunctional(): List<T> {
    return this.sortedBy { it }
}


















fun <T: Comparable<T>> MutableList<T>.bSortTest() {
    for (i in this.lastIndex downTo 1) {
       for (current in 0 until i) {
           if (this[current] > this[current + 1]) {
               val temp = this[current]
               this[current] = this[current + 1]
               this[current + 1] = temp
           }
       }
    }
}