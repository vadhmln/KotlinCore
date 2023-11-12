data class User(val name: String, val age: Int)

fun main(){
    val user = User("John", 20)
    val updatedUser = eat(user)
    println(updatedUser) // Output: User(name=John, age=20)
}

fun <T> eat(user: T): T{

    return user
}

