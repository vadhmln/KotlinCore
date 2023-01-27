import java.lang.IllegalArgumentException

fun main() {
    //non-null ссылки
//    var a: String = "abs" // non-null значение по умолчанию
//    a = null // null cannot be a value of a non-null type

    //null ссылки
//    var b: String? = "abc"
//    b = null // ok

    /*способы доступа к свойству, которое может быть null:
    1 - явно проверить на null (вместо используем следующий оператор)
    2 - использование оператора безопасного вызова ?
    3 - функция let (?.let)
    4 - элвис-оператор ?: (для замены null значениями по умолчанию)
    5 - оператор утверждения !! (для любителей NPE)
     */

    //1 - явно проверить на null
//    var b: String? = null
//    val c = if (b != null) b.length else -1

    //2 - использование оператора безопасного вызова ?
//    val a = "abs"
//    val b: String? = null
//    println(b?.length)
//    println(a?.length) // ненужный безопасный вызов

    //3 функция let (?.let)
    val name: String? = null
    name?.let { name.length }

    fun sendEmailTo(email: String) {
        println("Отправить имэйл $email")
    }

    var email: String? = "test@mail.ru"
//    email?.let { sendEmailTo(it) }//Отправить имэйл test@mail.ru
    email = null
    email?.let { sendEmailTo(it) }

    //операции над non-null значениями
    val listWithNulls: List<String?> = listOf("abs", null)
    for (item in listWithNulls) {
        item?.let { println(it) } // вывести abs и игнорируем null
    }

    //4 - элвис-оператор ?:
    var b: String? = null
//    val c = if (b != null) b.length else -1
    val c = b?.length ?: -1 // равно верхней строке

    //5 - оператор утверждения !!
//    val d = b!!.length

    //Безопасные приведения типов
    val aInt: Int? = b as? Int

    //Коллекции nullable типов
    val nullableList = listOf(1, null, 2)
    val intList = nullableList.filterNotNull()

    //Использование свойств с отложенной инициализацией - lateinit
    /*
    - используются только с var
    - только с non-nullable типами
    - перед использованием следует проинициализировать
     */
    val country = Country()
    country.name = "Russia"
    println(country.name)
}

//throw и return можно использовать справа от Элвис-оператора
fun foo(node: MyNode): String? {
    val parent = node.getParent() ?: return null
    val name = node.getName() ?: throw IllegalArgumentException("name expected")
    return null
}

class MyNode {
    fun getParent(): String? {
        return null
    }

    fun getName(): String? {
        return null
    }
}

//Свойства с отложенной инициализацией - lateinit
class Country {
    lateinit var name: String

//    init {
//        name = "Russia"
//    }
}
