import java.awt.Color
import java.time.Instant

fun main() {
    // единственное назначение - хранение данных
    // Компилятор автоматически формирует функции:
    // equals()/hashCode()/toString()/copy()/componentN()
    // Основной конструктор должен иметь как минимум один параметр;
    // Все параметры должны быть, как val или var (нежелательно);
    // data class не может быть абстрактными, open, sealed или inner;
    // от data class нельзя наследоваться
    // сам может реализовывать интерфейсы
    data class User(val name: String, val age: Int)

    // исключить свойство из автоматически созданной реализации
    // Только свойство name в автоматических функциях
    // если два объекта Person имеют разные age, они равны
    data class Person(val name: String) {
        var age: Int = 0
    }

    // data classes are equal:
    // both are of the same class,
    // their primary constructor property values are equal

    // equals - used when two objects are compared using ==
    data class A(val a: Int)

    val a1 = A(1)
    val a2 = A(1)
    val a3 = A(2)
    println(a1 == a1) // true
    println(a1 == a2) // true
    println(a1 == a3) // false

    // hashCode - used by collections that use the hash table algorithm
    // hashCode method typically transforms an address into a number
    // hashCode is used to transform an object into an Int

    // toString - used to represent an object as a string

    // copy - to create a new instance of a class
    // but with a concrete modification
    val person1 = User("Tom", 37)
    val person2 = person1.copy(age = 25)
    println(person1) // User(name=Tom, age=37)
    println(person2) // User(name=Tom, age=25)

    // copy creates a shallow copy of an object
    // if object holds a mutable state, a change in one object will be a
    // change in all its copies too
    data class StudentGrades(
        val studentId: String,
        // Code smell: Avoid using mutable objects in data classes
        val grades: MutableList<Int>
    )

    val grades1 = StudentGrades("1", mutableListOf())
    val grades2 = grades1.copy(studentId = "2")
    println(grades1) // StudentGrades(studentId=1, grades=[])
    println(grades2) // StudentGrades(studentId=2, grades=[])
    grades1.grades.add(5)
    println(grades1) // StudentGrades(studentId=1, grades=[5])
    println(grades2) // StudentGrades(studentId=2, grades=[5])
    grades2.grades.add(1)
    println(grades1) // StudentGrades(studentId=1, grades=[5, 1])
    println(grades2) // StudentGrades(studentId=2, grades=[5, 1])

    // no problem using copy for immutable values
    data class StudentGradesImmutable(
        val studentId: String,
        val grades: List<Int>
    )

    var gradesImmutable1 = StudentGradesImmutable("1", listOf())
    var gradesImmutable2 = gradesImmutable1.copy(studentId = "2")
    println(gradesImmutable1) // StudentGradesImmutable(studentId=1, grades=[])
    println(gradesImmutable2) // StudentGradesImmutable(studentId=2, grades=[])
    gradesImmutable1 = gradesImmutable1.copy(grades = gradesImmutable1.grades + 5)
    println(gradesImmutable1) // StudentGradesImmutable(studentId=1, grades=[5])
    println(gradesImmutable2) // StudentGradesImmutable(studentId=2, grades=[])
    gradesImmutable2 = gradesImmutable2.copy(grades = gradesImmutable2.grades + 1)
    println(gradesImmutable1) // StudentGradesImmutable(studentId=1, grades=[5])
    println(gradesImmutable2) // StudentGradesImmutable(studentId=2, grades=[1])

    // immutable properties, might be checked during the creation
    data class UserChecked(
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

    // деструктуризация
    val userDestructuring = User("Ben", 25)
    val (myName, myAge) = userDestructuring

    // componentN +++
    // we can name variables however we want
    val visited = listOf("Spain", "Morocco", "India")
    val (first, second, third) = visited
    println("$first $second $third") // Spain Morocco India

    val trip = mapOf(
        "Spain" to "Gran Canaria",
        "Morocco" to "Taghazout",
        "India" to "Rishikesh"
    )
    for ((country, city) in trip) {
        println("We loved $city in $country")
        // We loved Gran Canaria in Spain
        // We loved Taghazout in Morocco
        // We loved Rishikesh in India
    }

    // it is very easy to introduce errors by changing
    // the order of the primary constructor’s properties
    data class FullName(
        val firstName: String,
        val secondName: String,
        val lastName: String
    )

    val elon = FullName("Elon", "Reeve", "Musk")
    val (myFirstName, surname) = elon
    print("It is $myFirstName $surname!") // It is Elon Reeve!

    // Destructuring a single value in lambda
    data class UserLambda(
        val name: String,
        val surname: String,
    )

    val users = listOf(
        UserLambda("Nicola", "Corti")
    )
    users.forEach { u -> println(u) }
    // User(name=Nicola, surname=Corti)
    users.forEach { (u) -> println(u) }
    // Nicola

    /* Data classes are supposed to keep all the essential properties
     * in their primary constructor. Inside the body, we should only
     * keep redundant immutable properties, which means properties
     * whose value is distinctly calculated from primary constructor
     * properties, like fullName, which is calculated from
     * name and surname. */
    data class FullNameProperties(
        val name: String,
        val surname: String,
    ) {
        val fullName = "$name $surname"
    }

    val d1 = FullNameProperties("Tom", "Best")
    println(d1.fullName) // Tom Best

    // tuples very useful for local purposes, like:
    // When we immediately name values:
    val degrees = 0
    val (description, color) = when {
        degrees < 5 -> "cold" to Color.BLUE
        degrees < 23 -> "mild" to Color.YELLOW
        else -> "hot" to Color.RED
    }

    // To represent an aggregate that is not known in advance,
    // as is commonly the case in standard library functions:
    val numbers = listOf(1, 2, 3)
    val (odd, even) = numbers.partition { it % 2 == 1 }
    val map = mapOf(1 to "San Francisco", 2 to "Amsterdam")

    // function that parses a full name into a name and a surname
    // represent this name and surname as a Pair<String, String>:
//    fun String.parseName(): Pair<String, String>? {
//        val indexOfLastSpace = this.trim().lastIndexOf(' ')
//        if (indexOfLastSpace < 0) return null
//        val firstName = this.take(indexOfLastSpace)
//        val lastName = this.drop(indexOfLastSpace)
//        return Pair(firstName, lastName)
//    }
    val fullName = "Tom Best"
//    val (firstName, lastName) = fullName.parseName() ?: return
//    print("His name is $firstName") // Tom

    // it is not clear that Pair<String, String> represents a full name
    // it is not clear what the order of the values is
//    val (lastName, firstName) = fullName.parseName() ?: return
//    print("His name is $firstName") // Best

    // To make usage safer and the function easier to read,
    // we should use a data class instead:
    fun String.parseName(): FullNameProperties? {
        val indexOfLastSpace = this.trim().lastIndexOf(' ')
        if (indexOfLastSpace < 0) return null
        val firstName = this.take(indexOfLastSpace)
        val lastName = this.drop(indexOfLastSpace)
        return FullNameProperties(firstName, lastName)
    }
    val (firstName, lastName) = fullName.parseName() ?: return
    print("His name is $firstName $lastName")

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


//    var grades1 = StudentGrades("1", listOf())
//    var grades2 = grades1.copy(studentId = "2")
//    println(grades1) // Grades(studentId=1, grades=[])
//    println(grades2) // Grades(studentId=2, grades=[])
//    grades1 = grades1.copy(grades = grades1.grades + 5)
//    println(grades1) // Grades(studentId=1, grades=[5])
//    println(grades2) // Grades(studentId=2, grades=[])
//    grades2 = grades2.copy(grades = grades2.grades + 1)
//    println(grades1) // Grades(studentId=1, grades=[5])
//    println(grades2) // Grades(studentId=2, grades=[1])

//    data class User(
//        val name: String,
//        val surname: String,
//    ) {
//        init {
//            require(name.isNotBlank())
//            // throws exception if name is blank
//            require(surname.isNotBlank())
//            // throws exception if surname is blank
//        }
//    }

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

//    data class FullName(
//        val name: String,
//        val surname: String,
//    ) {
//        val fullName = "$name $surname"
//    }

//    val d1 = FullName("Boogy", "Chen")
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


// конструктор без параметров,
// значения всех свойств по умолчанию
data class UserDefaultParams(
    val name: String = "",
    val age: Int = 0
)

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

