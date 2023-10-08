//абстрактный класс: нельзя создать ero экземпляр
abstract class Animated {
    abstract fun animate() //абстрактная функция: она не имеет реализации и должна быть переопределена в подклассах
    open fun stopAnimating() {
    }

    fun animateTwice() {
    }
}

fun main() {
    val animals = arrayOf(
        Hippo(),
        Wolf(),
        Lion(),
        Cheetah(),
        Lynx(),
        Fox()
    )
    for (item in animals) {
        item.roam()
        item.eat()
    }
}

abstract class Animal {
    abstract fun roam()
    abstract fun eat()
}

abstract class Feline : Animal()
abstract class Canine : Animal()

class Hippo : Animal() {
    override fun roam() {
        println("Hippo is roaming!")
    }

    override fun eat() {
        println("Hippo is eating!")
    }

}

class Wolf : Canine() {
    override fun roam() {
        println("Wolf is roaming!")
    }

    override fun eat() {
        println("Wolf is eating!")
    }

}

class Fox : Canine() {
    override fun roam() {
        println("Fox is roaming!")
    }

    override fun eat() {
        println("Fox is eating!")
    }

}

class Lion : Feline() {
    override fun roam() {
        println("Lion is roaming!")
    }

    override fun eat() {
        println("Lion is eating!")
    }

}

class Cheetah : Feline() {
    override fun roam() {
        println("Cheetah is roaming!")
    }

    override fun eat() {
        println("Cheetah is eating!")
    }

}

class Lynx : Feline() {
    override fun roam() {
        println("Lynx is roaming!")
    }

    override fun eat() {
        println("Lynx is eating!")
    }

}
