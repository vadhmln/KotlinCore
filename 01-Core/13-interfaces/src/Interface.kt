fun main() {
    val roamables = listOf(
        Hippo(),
        Lion(),
        Fox(),
        Wolf(),
        Lynx(),
        Cheetah(),
        Vehicle()
    )

    for (item in roamables) {
//        item.roam()
        when {
            roamables is Feline -> item.roam()
//            is Fox -> item.makeNoise()
        }

    }
}

interface MyInterface {
    val prop: Int // абстрактное свойство
    val propertyWithImplementation: String
        get() = "foo"

    fun bar()
    fun foo()
}

//Класс или объект могут реализовать любое количество интерфейсов
class MyClass : MyInterface {
    override val prop = 20

    override fun bar() {
        TODO("Not yet implemented")
    }

    override fun foo() {
        TODO("Not yet implemented")
    }
}

//пользовательский get-метод
interface Roamable {
    var velocity: Int
        get() = 20 // Возвращает 20 при каждом обращении к свойству. Тем не менее
    // это свойство может определяться в любых классах, реализующих интерфейс

        //set-метод, не пытается обращаться к базовому полю данных свойства
        set(value) {
            println("Unable to update velocity")
        }

    fun roam()
}


//Наследование интерфейсов
interface Named {
    val name: String
}

interface Person : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}

data class Position(val x: Int, val y: Int)

data class Employee(
    // реализация 'name' не требуется
    override val firstName: String,
    override val lastName: String,
    val position: Position
) : Person

//Устранение противоречий при переопределении
interface A {
    fun foo() {
        print("A")
    }

    fun bar()
}

interface B {
    fun foo() {
        print("B")
    }

    fun bar() {
        print("bar")
    }
}

class C : A {
    override fun bar() {
        print("bar")
    }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}

abstract class Animal : Roamable {
    abstract override fun roam()
    abstract fun eat()
    abstract fun makeNoise()
}

abstract class Feline : Animal()
abstract class Canine : Animal()

class Wolf : Canine() {
    override fun roam() {
        println("Wolf is roaming!")
    }

    override fun eat() {
        println("Wolf is eating!")
    }

    override fun makeNoise() {
        println("Wolf is making a noise!")
    }

}

class Hippo : Animal() {
    override fun roam() {
        println("Hippo is roaming!")
    }

    override fun eat() {
        println("Hippo is eating!")
    }

    override fun makeNoise() {
        println("Hippo is making a noise!")
    }

}

class Fox : Canine() {
    override fun roam() {
        println("Fox is roaming!")
    }

    override fun eat() {
        println("Fox is eating!")
    }

    override fun makeNoise() {
        println("Fox is making a noise!")
    }

}

class Lion : Feline() {
    override fun roam() {
        println("Lion is roaming!")
    }

    override fun eat() {
        println("Lion is eating!")
    }

    override fun makeNoise() {
        println("Lion is making a noise!")
    }

}

class Cheetah : Feline() {
    override fun roam() {
        println("Cheetah is roaming!")
    }

    override fun eat() {
        println("Cheetah is eating!")
    }

    override fun makeNoise() {
        println("Cheetah is making a noise!")
    }

}

class Lynx : Feline() {
    override fun roam() {
        println("Lynx is roaming!")
    }

    override fun eat() {
        println("Lynx is eating!")
    }

    override fun makeNoise() {
        println("Lynx is making a noise!")
    }

}

class Vehicle : Roamable {
    override fun roam() {
        println("The Vehicle is roaming!")
    }
}

