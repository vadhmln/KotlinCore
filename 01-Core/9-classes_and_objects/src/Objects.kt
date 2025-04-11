fun main() {
    Payroll.calculateSalary()

}

// объект-одиночка
object Payroll {
    val allEmployees = mutableListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees) {
            /* ... */
        }
    }
}