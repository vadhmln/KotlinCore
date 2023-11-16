package maintanable

interface Cube {
    fun getVolume(): Double
}

interface Nut {
    fun getTaste(): String
}

interface Robot {
    fun getPower(): Int
}

class System(private val cube: Cube, private val nut: Nut, private val robot: Robot) {
    fun getSystemVolume(): Double {
        return cube.getVolume()
    }

    fun getSystemTaste(): String {
        return nut.getTaste()
    }

    fun getSystemPower(): Int {
        return robot.getPower()
    }
}

class WoodenCube : Cube {
    override fun getVolume(): Double {
        return 10.0
    }
}

class Almond : Nut {
    override fun getTaste(): String {
        return "sweet"
    }
}

class RobotAssistant : Robot {
    override fun getPower(): Int {
        return 100
    }
}

fun main() {
    val cube = WoodenCube()
    val nut = Almond()
    val robot = RobotAssistant()

    val system = System(cube, nut, robot)

    println("System volume: ${system.getSystemVolume()}")
    println("System taste: ${system.getSystemTaste()}")
    println("System power: ${system.getSystemPower()}")
}