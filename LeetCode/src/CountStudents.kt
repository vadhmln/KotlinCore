val students = listOf(1, 1, 0, 0).toIntArray()
val sandwiches = listOf(0, 1, 0, 1).toIntArray()

fun main() {
    val solution = SolutionCountStudents()

    println(solution.countStudents(students, sandwiches))
}

class SolutionCountStudents {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val studentsTemp = students.toMutableList()
        val sandwichesTemp = sandwiches.toMutableList()
        var count = 0

        while (studentsTemp.isNotEmpty()) {
            if (studentsTemp.first() == sandwichesTemp.first()) {
                studentsTemp.removeAt(0)
                sandwichesTemp.removeAt(0)
                count = 0
            } else {
                val first = studentsTemp.removeAt(0)
                studentsTemp.add(first)
                count++
                if (count == studentsTemp.size) {
                    break
                }
            }
        }
        return studentsTemp.size
    }
}