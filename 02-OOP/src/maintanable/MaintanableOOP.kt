interface Animal {
    fun eat()
}

class Lion(private val animal: Animal) {
    fun eat() {
        println("The lion is eating.")
        animal.eat()
    }
}

class Leopard(private val animal: Animal) {
    fun eat() {
        println("The leopard is eating.")
        animal.eat()
    }
}

class Human(private val animal: Animal) {
    fun eat() {
        println("The human is eating.")
        animal.eat()
    }
}

fun main(args: Array<String>) {
    val animal: Animal = object : Animal {
        override fun eat() {
            println("The animal is eating.")
        }
    }

    val lion = Lion(animal)
    val leopard = Leopard(animal)
    val human = Human(animal)

    lion.eat()
    leopard.eat()
    human.eat()
}