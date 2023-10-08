//изменяемая ссылка с отложенной инициализацией, используйте ключевое слово lateinit, которое
//имеет тот же эффект, но без автоматической инициализации по требованию
lateinit var nameLateInit: String

fun main() {
    val name: String by lazy { getName() }
    println("hey1")
    val name2: String by lazy { name }
    println("hey2")
    println(name)
    println(name2)
    println(name)
    println(name2)



    nameLateInit = getName()
}
fun getName(): String {
    println("computing name...")
    return "Mickey"
}
/*
Свойства в классах Kotlin могут быть объявлены либо как — var или val
 */

class Address() {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"
    val valVariable = ""

    //Когда значение неизвестно во время объявления и не изменяется после инициализации
    val nameLazy: String by lazy { getName() }

    //Вместо лямбда-выражения можно также использовать ссылку на функцию
    val nameLazyReferenceFun: String by lazy(::getName)

    //к свойству обращаются по имени
    fun copyAddress(address: Address): Address {
        val result = Address() // в Kotlin нет никакого слова `new`
        result.name = address.name // вызов методов доступа
        result.street = address.street
        // ...
        return result
    }

    /*
     *Геттер и сеттер можно не указывать. Также необязательно указывать тип свойства,
     *если он может быть выведен из инициализатора или из возвращаемого типа геттера
     */

    var initialized = 1 // имеет тип Int, стандартный геттер и сеттер
// var allByDefault // ошибка: необходима явная инициализация,
// предусмотрены стандартные геттер и сеттер

    /*
     *Синтаксис объявления констант имеет два отличия от синтаксиса объявления изменяемых переменных:
     *во-первых, объявление константы начинается с ключевого слова val вместо var,
     *а во-вторых, объявление сеттера запрещено
     */

    val simple: Int? = null  // имеет тип Int, стандартный геттер,

    // должен быть инициализирован в конструкторе
    val inferredType = 1     // имеет тип Int и стандартный геттер
}

/*
Вы можете самостоятельно определить методы доступа для свойства.
Если вы определяете пользовательский геттер,
он будет вызываться каждый раз, когда вы обращаетесь к свойству
(таким образом, вы можете реализовать вычисляемое свойство)
 */

class Rectangle(val width: Int, val height: Int) {
    val area: Int
        get() = this.width * this.height // тип свойства необязателен, поскольку он может быть выведен

    // из возвращаемого типа геттера
    //Вы можете опустить тип свойства, если его можно определить с помощью геттера
//    val area get() = this.width * this.height

    /*
    Если вы определяете пользовательский сеттер, он будет вызываться каждый раз,
    когда вы присваиваете значение свойству, за исключением его инициализации
     */

    var stringRepresentation: String
        get() = this.toString()
        set(value) {                 //По договорённости, имя параметра сеттера - value,
                                     // но вы можете использовать любое другое
            setDataFromString(value) // парсит строку и устанавливает
                                     // значения для других свойств
        }

    private fun setDataFromString(value: String) {
        TODO("Not yet implemented")
    }

    /*
    Если вам нужно изменить область видимости метода доступа или пометить его аннотацией,
    при этом не внося изменения в реализацию по умолчанию,
    вы можете объявить метод доступа без объявления его тела
     */

    var setterVisibility: String = "abc"
        private set // сеттер имеет private доступ и стандартную реализацию

    var setterWithAnnotation: Any? = null
        @Inject set // аннотирование сеттера с помощью Inject
}