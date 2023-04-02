import javax.naming.Context
import javax.print.attribute.Attribute
import javax.print.attribute.AttributeSet

fun main() {
    /*
     * Для создания экземпляра класса конструктор вызывается так, как если бы он был обычной функцией
     * нет ключевого слова new
     */
    val person = Person("Name", "Last name", 20)

}

//основной конструктор (primary constructor)
class Stuff constructor(name: String)

/*
 * Если у основного конструктора нет аннотаций и модификаторов видимости,
 * ключевое слово constructor может быть опущено
 */
class Human(age: Int) // для параметра не должно быть создано свойство, т.к. нет val - var

//простой класс
class User(val nickname: String) // val означает, что для параметра должно быть создано соответствующее свойство

//то же самое - явный код
class UserImplementation constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

//инициализирующий код можно совместить с объявлением свойства
class UserNextImplementation(_nickname: String) {
    val nickname = _nickname
}

/*
Основной конструктор не может содержать в себе исполняемого кода.
Инициализирующий код может быть помещён в соответствующие блоки (initializers blocks),
которые помечаются словом init
 */
class InitOrder(name: String) {
    val firstProperty = "Первое свойство: $name".also(::println)

    init {
        println("Первый блок инициализации: $name")
    }

    val secondProperty = "Второе свойсто: ${name.length}".also(::println)

    init {
        println("Второй блок инициализации: ${name.length}")
    }
}

/*
параметры основного конструктора могут быть использованы в инициализирующем блоке.
Они также могут быть использованы при инициализации свойств в теле класса.
 */
class Customer(name: String) {
    val customerKey = name.uppercase()
}

/*
Для объявления и инициализации свойств основного конструктора
в Kotlin есть лаконичное синтаксическое решение:
 */
class Person(val firstName: String, val lastName: String, var age: Int)

/*
Такие объявления также могут включать в себя значения свойств класса по умолчанию
 */
class PersonDefaultParam(val firstName: String = "", val lastName: String = "", var isEmployed: Boolean = true)

/*
можете использовать завершающую запятую при объявлении свойств класса
 */
class PersonTrailingComma(
    val firstName: String,
    val lastName: String,
    var age: Int,          //завершающая запятая
)

/*
Если у конструктора есть аннотации или модификаторы видимости, ключевое слово
constructor обязательно, и модификаторы используются перед ним
 */
class CustomerModifiers @Inject private constructor(name: String)

/*
дополнительные конструкторы (secondary constructors),
перед которыми используется ключевое слово constructor
 */

class PersonSecond(val pets: MutableList<Pet> = mutableListOf())
class Pet {
    constructor(owner: PersonSecond) {
        owner.pets.add(this)
    }
}

/*
Если у класса есть основной конструктор, каждый дополнительный конструктор должен
прямо или косвенно ссылаться (через другой(ие) конструктор(ы)) на основной.
Осуществляется это при помощи ключевого слова this
 */

class PersonConstructor(val name: String) {
    private val children = mutableListOf<PersonConstructor>()

    constructor(name: String, parent: PersonConstructor) : this(name) {
        parent.children.add(this)
    }
}

/*
Даже если у класса нет основного конструктора на него все равно происходит неявная
ссылка и блоки инициализации выполняются также
 */

class Constructors {
    init {
        println("Блок инициализации")
    }

    constructor(i: Int) {
        println("Constructor $i")
    }
}

/*
Если в абстрактном классе не объявлено никаких конструкторов (основного или дополнительных),
у этого класса автоматически сгенерируется пустой конструктор без параметров.
Видимость этого конструктора будет public.
Если вы не желаете иметь класс с открытым public конструктором, вам необходимо объявить
пустой конструктор с соответствующим модификатором видимости
 */

class DontCreateMe private constructor() {}

/*
необходимо расширить класс фреймворка, поддерживающий
несколько конструкторов для инициализации класса различными способами
 */
open class View {
    constructor(ctx: Context) {
// некоторый код
    }

    constructor(ctx: Context, attr: AttributeSet) {
// некоторый код
    }
}

//Чтобы расширить этот (View) класс, объявите те же конструкторы:
class MyButton : View {
    constructor(ctx: Context) : this(ctx, MY_STYLE) {
        // некоторый код
    }

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {
        // некоторый код
    }
}

object MY_STYLE : AttributeSet {
    override fun get(category: Class<*>?): Attribute {
        TODO("Not yet implemented")
    }

    override fun add(attribute: Attribute?): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(category: Class<*>?): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(attribute: Attribute?): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsKey(category: Class<*>?): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(attribute: Attribute?): Boolean {
        TODO("Not yet implemented")
    }

    override fun addAll(attributes: AttributeSet?): Boolean {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

    override fun toArray(): Array<Attribute> {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

}


//Классы могут быть вложены в другие классы
class OuterWithNested {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }
}

val demo = OuterWithNested.Nested().foo() // 2

/*
Вы также можете использовать интерфейсы с вложенностью. Возможны любые комбинации классов
и интерфейсов: вы можете вкладывать интерфейсы в классы, классы в интерфейсы и интерфейсы в интерфейсы
 */

interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OuterClass {
    class InnerClass
    interface InnerInterface
}

/*
Класс, отмеченный как внутренний с помощью слова inner, может иметь доступ к членам внешнего класса.
Внутренние классы содержат ссылку на объект внешнего класса
 */

class Outer {
    private val bar = 1

    inner class Inner {
        fun foo() = bar
    }
}

val result = Outer().Inner().foo() // 1


annotation class Inject
