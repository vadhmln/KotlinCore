package atomic_system
/*
В этом примере мы создали три объекта, каждый из которых реализует интерфейс Action.
Каждый объект представляет определенное действие, которое может быть выполнено системой.
Обратите внимание, что каждый объект является атомарным и независимым от других объектов.
Затем мы создали список всех доступных действий и запросили ввод пользователя.
Система ищет объект, который может выполнить запрошенное действие, и выполняет его.
Объект, который может выполнить действие, выбирается на основе его свойств и состояния.
 */
interface Action {
    fun execute()
}

object Action1 : Action {
    override fun execute() {
        println("Action 1 executed")
    }
}

object Action2 : Action {
    override fun execute() {
        println("Action 2 executed")
    }
}

object Action3 : Action {
    override fun execute() {
        println("Action 3 executed")
    }
}

fun main() {
    val actions = listOf(Action1, Action2, Action3)
    val input = readLine()
    val action = actions.firstOrNull { it.javaClass.simpleName == input }
    action?.execute() ?: println("Invalid input")
}