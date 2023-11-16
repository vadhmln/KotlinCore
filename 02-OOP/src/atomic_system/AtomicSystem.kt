package atomic_system
/*
пример системы на языке Kotlin, которая не использует классы, а использует объекты-одиночки
и паттерн “Наблюдатель”. В этом примере система представлена объектом-одиночкой System,
который содержит список наблюдателей observers. Объекты, которые должны выполнять запросы системы,
реализуют интерфейс Observer и регистрируются в системе как наблюдатели. Когда система нуждается в новом объекте,
она создает его и регистрирует в качестве наблюдателя. Затем система уведомляет всех наблюдателей о новом объекте,
и если объект понимает, что он может выполнить запрос системы, он выполняет его.
Эта система динамическая, так как новые объекты могут быть созданы в любой момент времени, и атомарная,
так как каждый объект является независимым и не зависит от других объектов.
 */
//object System {
//    private val observers = mutableListOf<Observer>()
//
//    fun registerObserver(observer: Observer) {
//        observers.add(observer)
//    }
//
//    fun removeObserver(observer: Observer) {
//        observers.remove(observer)
//    }
//
//    fun notifyObservers() {
//        observers.forEach { it.update() }
//    }
//
//    fun requestNewObject() {
//        // Создание нового объекта
//        val newObject = Object()
//        // Регистрация нового объекта в качестве наблюдателя
//        registerObserver(newObject)
//        // Уведомление всех наблюдателей о новом объекте
//        notifyObservers()
//    }
//}

interface Observer {
    fun update()
}

class Object : Observer {
    override fun update() {
        // Выполнение запроса системы
    }
}

class Phone : Observer {
    override fun update() {
        // Выполнение запроса на звонок
    }

    fun makeCall(number: String) {
        // Выполнение звонка
        println(number)
    }
}

fun main() {
    val phone = Phone()
//    System.registerObserver(phone)
//    System.requestNewObject()
    phone.makeCall("123-456-7890")
}

