class MyCow  {
    fun move() {
        println("The cow is moving.")
    }
}

class MyMover() {
    fun move(any: Any) {
        println("The cow is being moved.")
    }
}

fun main() {
    val cow = MyCow()
    val mover = MyMover()

    cow.move()
    mover.move(cow)
}