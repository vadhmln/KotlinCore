package mykotlin

fun main() {
    //Вы можете вызвать объект-компаньон через имя класса
    A.bar()
    val subscribingUser = UserCompanionObject.newSubscribingUser("bob@gmail.com")
    val facebookUser = UserCompanionObject.newFacebookUser(5)
}

//обращение к методам и свойствам объекта непосредственно через имя содержащего его класса,
//без явного указания имени объекта
class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }

}

//Определение класса с несколькими вторичными конструкторами
class User {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }

    private fun getFacebookName(facebookAccountId: Int) =
        facebookAccountId.toString()

}

//Замещение вторичных конструкторов фабричными методами
class UserCompanionObject private constructor(val nickname: String) {

    companion object {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) =
            User(getFacebookName(accountId))

        private fun getFacebookName(facebookAccountId: Int) =
            facebookAccountId.toString()
    }
}
