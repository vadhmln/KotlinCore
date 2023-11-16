package atomic_system

fun main() {
    val system = System
    val button = Button(system)

    button.click("action1")
    button.click("action2")
}

interface SystemInterface {
    fun requestAction(action: String)
}

object System {
    private val listeners = mutableListOf<Listener>()

    fun addListener(listener: Listener) {
        listeners.add(listener)
    }

    fun removeListener(listener: Listener) {
        listeners.remove(listener)
    }

    fun requestAction(action: String) {
        listeners.forEach { listener ->
            if (listener.canHandle(action)) {
                listener.handle(action)
            }
        }
    }

    fun createObject(): Object {
        return Object()
    }

    interface Listener {
        fun canHandle(action: String): Boolean
        fun handle(action: String)
    }

    class Object {
        fun handle(action: String) {
            // Handle the action
        }
    }
}

class Button(private val system: System) {
    fun click(action: String) {
        system.requestAction(action)
    }
}
