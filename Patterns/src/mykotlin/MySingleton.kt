package mykotlin

import mykotlin.CaseInsensitiveFileComparator.files
import java.io.File

object MySingleton

//фонд заработной платы организации - обычно один
object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees) {
            //...
        }
    }
}

fun main() {
    Payroll.allEmployees.add(Person("Ben", 34))
    Payroll.allEmployees.add(Person("Tom", 25))
    Payroll.calculateSalary()

    for (person in Payroll.allEmployees) {
        println("Person name: ${person.name}; Person age: ${person.age}")
    }
    //    Payroll.allEmployees.forEach { println("Person name: ${it.name}; Person age: ${it.age}") }

    println(
        CaseInsensitiveFileComparator.compare(
            File("/User"), File("/user")
        )
    )// 0

    println(files.sortedWith(CaseInsensitiveFileComparator)) // [\a, \Z]

    val persons = listOf( Person( "Bob", 21) , Person("Zen", 43) )
    println(persons.sortedWith(Person.NameComparator)) // [Person(name=Bob, age=21), Person(name=Zen, age=43)]

}

//Реализация интерфейса Comparator с помощью объявления объекта
object CaseInsensitiveFileComparator : Comparator<File> {
    val files = listOf(File("/Z"), File("/a"))

    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(
            file2.path,
            ignoreCase = true
        )
    }
}


data class Person(
    val name: String,
    val age: Int,
) {
    //Реализация интерфейса Comparator как вложенного объекта
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            p1.name.compareTo(p2.name)
    }
}