fun main() {
    //реализация без использования data класса
    val albert = Student(
        firstName = "Albert",
        lastName = "Einstein",
        id = 1
    )
    val richard = Student(
        firstName = "Richard",
        lastName = "Feynman",
        id = 2
    )
    val albertCopy = albert.copy()
    println(albert) // > Student (firstName=Albert, lastName=Einstein, id=1)
    println(richard) // > Student (firstName=Richard, lastName=Feynman, id=2)
    println(albert == richard) // > false
    println(albert == albertCopy) // > true
    println(albert === albertCopy) // > false

    //реализация с использованием data класса
    val marie = StudentData("Marie", "Curie", id = 1)
    val emmy = StudentData("Emmy", "Noether", id = 2)
    val marieCopy = marie.copy()
    println(marie) // > StudentData(firstName=Marie, lastName=Curie, id=1)
    println(emmy) // > StudentData(firstName=Emmy, lastName=Noether, id=2)
    println(marie == emmy) // > false
    println(marie == marieCopy) // > true
    println(marie === marieCopy) // > false

    //Деструктуризирующее присваивание
    val (firstName, lastName, id) = marie
    println(firstName) // > Marie
    println(lastName) // > Curie
    println(id) // > 1
}

/*
data классы, единственным назначением которых является хранение данных
функционал и некоторые служебные функции таких классов зависят от самих данных,
которые в них хранятся
 */

data class User(val name: String, val age: Int)

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
data class Person(val name: String) {
    var age: Int = 0
}
/*
Только свойство name будет учитываться в реализациях функций toString(), equals(), hashCode() и copy(),
и будет создана только одна компонентная функция component1(). Даже если два объекта класса Person будут
иметь разные значения свойств age, они будут считаться равными.
 */

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

