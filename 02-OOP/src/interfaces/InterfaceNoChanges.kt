package interfaces

class NewNokia {
    fun makeCall() {
        println("Making a call with NewNokia.")
    }
}

class NewPhilips {
    fun makeCall() {
        println("Making a call with NewPhilips.")
    }
}

class NewCanon {
    fun takePicture() {
        println("Taking a picture with NewCanon.")
    }
}

class NewNikon {
    fun takePicture() {
        println("Taking a picture with NewNikon.")
    }

}

// This class combines both Camera and Phone, but it's not flexible
// to add new implementations
class MyCameraPhone(
    private val camera: NewCanon,
    private val phone: NewNokia,
) {
    fun takePicture() {
        camera.takePicture()
    }

    fun makeCall() {
        phone.makeCall()
    }
}

class MyCameraPhone1(
    private val camera: NewNikon,
    private val phone: NewPhilips,
) {
    fun takePicture() {
        camera.takePicture()
    }

    fun makeCall() {
        phone.makeCall()
    }
}

fun main() {
    val nokiaPhone = NewNokia()
    val canonCamera = NewCanon()
    val newNikon = NewNikon()
    val newPhilips = NewPhilips()

    // If you want to add a new type of camera or phone, you need
    // to change this code
    val myCameraPhone = MyCameraPhone(canonCamera, nokiaPhone)

    // чтобы добавить новую имплементацию нужно сделать еще один
    // такой же объект как MyCameraPhone, но с типами newNikon, newPhilips
    // что приведет к дублированию кода
    val myCameraPhone1 = MyCameraPhone1(newNikon, newPhilips)
    myCameraPhone.takePicture()
    myCameraPhone.makeCall()
}