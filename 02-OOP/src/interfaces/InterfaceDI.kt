package interfaces

interface Camera {
    fun takePicture()
}

interface MobilePhone {
    fun makeCall()
}

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

class Canon : Camera {
    override fun takePicture() {
        println("Taking a picture with Canon.")
    }
}

fun main() {
    val nokia = Nokia()
    val canon = Canon()
    val cameraPhone = CameraPhone(canon, nokia)

    cameraPhone.takePicture()
    cameraPhone.makeCall()
}