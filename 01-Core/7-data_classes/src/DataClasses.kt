import java.time.Instant
import java.time.Year

fun main() {
    //реализация без использования data класса
//    val albert = Student(
//        firstName = "Albert",
//        lastName = "Einstein",
//        id = 1
//    )
//    val richard = Student(
//        firstName = "Richard",
//        lastName = "Feynman",
//        id = 2
//    )
//    val albertCopy = albert.copy()
//    println(albert) // > Student (firstName=Albert, lastName=Einstein, id=1)
//    println(richard) // > Student (firstName=Richard, lastName=Feynman, id=2)
//    println(albert == richard) // > false
//    println(albert == albertCopy) // > true
//    println(albert === albertCopy) // > false

    //реализация с использованием data класса
//    val marie = StudentData("Marie", "Curie", id = 1)
//    val emmy = StudentData("Emmy", "Noether", id = 2)
//    val marieCopy = marie.copy()
//    println(marie) // > StudentData(firstName=Marie, lastName=Curie, id=1)
//    println(emmy) // > StudentData(firstName=Emmy, lastName=Noether, id=2)
//    println(marie == emmy) // > false
//    println(marie == marieCopy) // > true
//    println(marie === marieCopy) // > false

    //Деструктуризирующее присваивание
//    val (firstName, lastName, id) = marie
//    println(firstName) // > Marie
//    println(lastName) // > Curie
//    println(id) // > 1

//    data class User(var name: String, val age: Int)
//
//    val user1 = User(name = "Tom", age = 31)
//    val (name, age) = user1

//    println("The name is $name. The age is $age.")

//    val user2 = User(name = "Tom", age = 31)
//    val user3 = User(name = "Ben", age = 31)
//    val set = hashSetOf(user1, user2, user3)
//
//    println("Set contains ${set.size} elements")
//    val result = set.contains(User("Tom", 31))
//    println("Search result = $result")

//    if (user1 == user2) {
//        println("Pointing to the same memory location")
//    } else {
//        println("Pointing to the different memory location")
//    }
//    if (user1 == user2) {
//        println("Same")
//    } else {
//        println("Different")
//    }

    data class StudentGrades(
        val studentId: String,
        val grades: List<Int>
    )

    var grades1 = StudentGrades("1", listOf())
    var grades2 = grades1.copy(studentId = "2")
//    println(grades1) // Grades(studentId=1, grades=[])
//    println(grades2) // Grades(studentId=2, grades=[])
//    grades1 = grades1.copy(grades = grades1.grades + 5)
//    println(grades1) // Grades(studentId=1, grades=[5])
//    println(grades2) // Grades(studentId=2, grades=[])
//    grades2 = grades2.copy(grades = grades2.grades + 1)
//    println(grades1) // Grades(studentId=1, grades=[5])
//    println(grades2) // Grades(studentId=2, grades=[1])

    data class User(
        val name: String,
        val surname: String,
    ) {
        init {
            require(name.isNotBlank())
            // throws exception if name is blank
            require(surname.isNotBlank())
            // throws exception if surname is blank
        }
    }

    data class Player(
        val id: Int,
        val name: String,
        val points: Int
    )

    val player = Player(0, "Gecko", 9999)
//    val (id, name, pts) = player
//    println(id) // 0
//    println(name) // Gecko
//    println(pts) // 9999

//    val (id, name, pts) = player
    // is compiled to
    val id: Int = player.component1()
    val name: String = player.component2()
    val pts: Int = player.component3()

    data class Dog(
        val name: String,
    ) {
        // Bad practice, avoid mutable properties in data classes
        var trained = false
    }

//    val d1 = Dog("Cookie")
//    d1.trained = true
//    println(d1) // Dog(name=Cookie)
//    // so nothing about trained property
//    val d2 = d1.copy()
//    println(d1.trained) // true
//    println(d2.trained) // false
//    // so trained value not copied

    data class FullName(
        val name: String,
        val surname: String,
    ) {
        val fullName = "$name $surname"
    }

    val d1 = FullName("Boogy", "Chen")
//    println(d1.fullName) // Boogy Chen
//    println(d1) // FullName(name=Boogy, surname=Chen)
//    val d2 = d1.copy()
//    println(d2.fullName) // Boogy Chen
//    println(d2) // FullName(name=Cookie, surname=Chen)

    data class Book(
        var title: String,
        val author: String,
        val year: Int
    ) {
        var age: Int = 0

        constructor(title: String, author: String, year: Int, age: Int) : this(title, author, year) {
            this.age = age
        }
    }

    data class Cat(val name: String) {
        var age = 0;

        constructor(name: String, age: Int) : this(name) {
            this.age = age;
        }
    }
//
//    val a = Book(title = "ABC", author = "Jhon", 1980)
//    println(a)

//    class Book(val title: String,
//               val author: String,
//               val year: Int) {
//        operator fun component1() = title
//        operator fun component2() = author
//        operator fun component3() = year
//    }

    val books = ArrayList<Book>()
    books.add(Book("ABC", "Tom", 2015))
    books.add(Book("What", "Tom", 2016))
    books.add(Book("River", "Sam", 2007))

    for ((t, a, y) in books) {
        println("$y, $t")
    }

    val (title, _, year) = books

}


/*
data классы, единственным назначением которых является хранение данных
функционал и некоторые служебные функции таких классов зависят от самих данных,
которые в них хранятся
 */

//data class User(var name: String, val age: Int)

/*
Компилятор автоматически формирует следующие члены данного класса из свойств,
объявленных в основном конструкторе:
equals()
hashCode()
toString()
copy()
componentN()
 */

/*
для того,чтобы у сгенерированного в jvm класса был конструктор без параметров, значения всех свойств
должны быть заданы по умолчанию
 */

data class UserDefaultParams(val name: String = "", val age: Int = 0)

//Свойства, объявленные в теле класса
//data class Person(val name: String) {
//    var age: Int = 0
//}
/*
Только свойство name будет учитываться в реализациях функций toString(), equals(), hashCode() и copy(),
и будет создана только одна компонентная функция component1(). Даже если два объекта класса Person будут
иметь разные значения свойств age, они будут считаться равными.
 */



//Деструктуризация объектов данных
//data class Person(val name: String, val registered: Instant = Instant.now())
//без деструктуризации
fun show(persons: List<Person>) {
    for ((name, date) in persons)
        println("$name's registration date: $date")
}

//c деструктуризацией
fun showDestruct(persons: List<Person>) {
    for (person in persons)
        println("${person.component1()}'s registration date: ${person.component2()}")
}

//конструкция "companion object" для статических членов
data class Person(
    val name: String,
    val registered: Instant = Instant.now()
) {
    companion object {
        fun create(xml: String): Person {
            TODO("Реализовать создание экземпляра Person из строки с кодом XML")
        }
    }
}

// без использования data класса
class Student(
    var firstName: String,
    var lastName: String,
    var id: Int
) {
    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + firstName.hashCode()
        result = prime * result + id
        result = prime * result + lastName.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (javaClass != other.javaClass)
            return false
        val obj = other as Student?
        if (firstName != obj?.firstName)
            return false
        if (id != obj.id)
            return false
        if (lastName != obj.lastName)
            return false
        return true
    }

    override fun toString(): String {
        return "Student (firstName=$firstName, lastName=$lastName,id = $id)"
    }

    fun copy(
        firstName: String = this.firstName,
        lastName: String = this.lastName,
        id: Int = this.id
    ) = Student(firstName, lastName, id)
}

//с использованием data класса
data class StudentData(
    var firstName: String,
    var lastName: String,
    var id: Int
)

