/*
как реализовать поведение когда корова двигается и может быть передвинута.
как это реализовать в стиле ооп не нарушая срп и не используя наследование.
то есть у коровы есть метод мув, когда она хочет двигаться сама.
и есть поведение когда ее двигают. кому приписать поведение когда ее двигают.
можно дать другим объектам возможность двигать другие

В объектно-ориентированном стиле на Kotlin можно реализовать поведение коровы,
используя композицию. Композиция - это механизм, который позволяет создавать сложные
объекты из более простых объектов, объединяя их вместе. В данном случае,
мы можем определить класс Cow, который содержит метод move, который вызывается,
когда корова двигается сама по себе. Затем мы можем определить класс Mover,
который содержит метод move, который вызывается, когда корову двигают.
Класс Mover может принимать объект Cow в качестве аргумента и вызывать его метод move.
Также мы можем определить интерфейс Movable, который определяет метод move,
и реализовать этот интерфейс в классе Mover, чтобы дать другим объектам возможность двигать корову.
 */

interface Movable {
    fun move()
}

class Cow : Movable {
    override fun move() {
        println("The cow is moving.")
    }
}

class Dogor : Movable {
    override fun move() {
        println("The Dogor is moving.")
    }
}

class Mover(private val movable: Movable) : Movable {
    override fun move() {
        println("The cow is being moved.")
        movable.move()
    }
}

//class Mover(private vararg val movable: Movable) : Movable {
//    override fun move() {
//        println("The cow is being moved.")
//        movable.forEach {
//            it.move()
//        }
//    }
//}

fun main() {
    val cow = Cow()
    val dogor = Dogor()
//    val mover = MoverList(cow, dogor)

    cow.move()
//    mover.move()
}

/*
AnotherAnimal реализует интерфейс Movable, а Mover также реализует интерфейс Movable
и содержит объект типа Movable. Метод move() класса Mover вызывает метод move() объекта movable,
который может быть экземпляром класса AnotherAnimal или любого другого класса, реализующего интерфейс Movable.
Таким образом, Mover может использоваться для перемещения любого объекта, реализующего интерфейс Movable,
включая AnotherAnimal. Это делает код более гибким и расширяемым, поскольку вы можете легко заменить
AnotherAnimal на другой класс, реализующий интерфейс Movable, без необходимости вносить изменения в код,
который использует Mover.
 */

class AnotherAnimal : Movable {
    override fun move() {
        println("The animal is moving.")
    }
}