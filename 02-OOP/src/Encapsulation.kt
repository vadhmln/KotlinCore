fun main() {
    val human = Human(30, 80, 180, 1)
    val cow = Cow(age = 2, weight = 150, height = 1, color = 1)
    val dog = Dog(age = 2, weight = 150, height = 1)
    val apple = Apple(color = 3, weight = 1)
    val food = cow.eat(apple)
    val suitableCow = human.catch(cow.with(age = 1, weight = 150, height = 1, color = 1))
    val suitableDog = human.catch(dog.with(age = 2, weight = 150, height = 1))

    if (suitableCow) {
        println("The cow is suitable")
    } else println("Catch another one!")

    if (suitableDog) {
        println("The dog is suitable")
    } else println("Catch another one!")

    if (food) {
        println("Food is suitable")
    } else println("Eat something else!")
}

class Cow(
    private val age: Int,
    private val weight: Int,
    private val height: Int,
    private val color: Int,
) {

    fun eat(any: Any): Boolean {
        return when (any) {
            is Food -> true
            else -> false
        }
    }

    fun <T> eat(any: T): T {
        return any
    }

    fun with(age: Int = 0, weight: Int = 0, height: Int = 0, color: Int = 0): Boolean {
        var matched = false
        if (this.age == age && this.weight == weight && this.height == height && this.color == color) {
            matched = true
        }
        return matched
    }
}

class Human(
    val age: Int,
    val weight: Int,
    val height: Int,
    val color: Int,
) {

    fun <T> catch(any: T): T = any
}

class Dog(
    private val age: Int,
    private val weight: Int,
    private val height: Int,
)  {

    fun with(age: Int = 0, weight: Int = 0, height: Int = 0,): Boolean {
        var matched = false
        if (this.age == age && this.weight == weight && this.height == height) {
            matched = true
        }
        return matched
    }
}

interface Food {

}

class Apple(
    private val color: Int,
    private val weight: Int,
) : Food {

    fun withParameters(color: Int, weight: Int): Boolean {
        var matched = false
        if (this.color == color && this.weight == weight) {
            matched = true
        }
        return matched
    }
}


//var suitable = false
//for ((i, param) in parameters.withIndex()) {
//    if (param == parameters[i]) {
//        suitable = true
//    }
//}
//return suitable

//    fun withParameters(age: Int = 0, weight: Int = 0, height: Int = 0, color: Int = 0): Boolean {
//        var suitable = false
//        if (this.age == age && this.weight == weight && this.height == height && this.color == color) {
//            suitable = true
//        }
//        return suitable
//    }

//    fun <T> catch(t: T): T {
//        return t
//    }

//override fun with(vararg parameters: Any): Boolean {
//    var matched = false
//    for ((index, param) in attributes.withIndex()) {
//        if (attributes[index] == parameters[index]) {
//            matched = true
//        }
//    }
//    return matched
//}

