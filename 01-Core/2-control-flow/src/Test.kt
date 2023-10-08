package control_flow

val n = input.nextInt()
val rowList = mutableListOf<String>()
val stringArrayTwoD = mutableListOf<MutableList<String>>()
val answer2d = mutableListOf<MutableList<String>>()

fun main() {
    for (i in 0 until n) {
        rowList.add(input.next())
    }

    for (row in rowList.indices) {
        stringArrayTwoD.add(rowList[row].split("").drop(1).dropLast(1).toMutableList())
    }

    for (row in stringArrayTwoD.indices) {
        answer2d.add(rowList[row].split("").drop(1).dropLast(1).toMutableList())
    }

    for (row in answer2d.indices) {
        for (item in answer2d[row].indices) {
            answer2d[row][item] = "-"
        }
    }

    for (row in stringArrayTwoD) {
        for (item in row) {
            print(item)
        }
        println()
    }

    for (row in answer2d) {
        for (item in row) {
            print(item)
        }
        println()
    }
}
