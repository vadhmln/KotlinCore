interface Camera {
    fun takePicture()
}

interface MobilePhone {
    fun makeCall()
}

// This class combines both Camera and Phone, and is flexible
// to add new implementations
class CameraPhone(
    private val camera: Camera,
    private val phone: MobilePhone
) : Camera, MobilePhone {
    override fun takePicture() {
        camera.takePicture()
    }

    override fun makeCall() {
        phone.makeCall()
    }
}

class Nokia : MobilePhone {
    override fun makeCall() {
        println("Making a call with Nokia.")
    }
}

class Philips : MobilePhone {
    override fun makeCall() {
        println("Making a call with Philips.")
    }
}

class Canon : Camera {
    override fun takePicture() {
        println("Taking a picture with Canon.")
    }
}

class Nikon : Camera {
    override fun takePicture() {
        println("Taking a picture with Nikon.")
    }

}

fun main() {
    // You can add new implementations of Camera and MobilePhone without
    // changing this code
    val nokia = Nokia()
    val philips = Philips()
    val canon = Canon()
    val nikon = Nikon()
    val cameraPhone = CameraPhone(canon, nokia)
    val cameraPhone2 = CameraPhone(nikon, philips)


    cameraPhone.takePicture()
    cameraPhone.makeCall()

    cameraPhone2.takePicture()
    cameraPhone2.makeCall()
}

/*
Таким образом, вы можете легко добавлять новые реализации Camera и MobilePhone,
не изменяя код CameraPhone.
 */