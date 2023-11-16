interface Camera {
    fun takePicture()
}

interface MobilePhone {
    fun makeCall()
}

// This class combines both Camera and Phone, and is flexible
// to add new implementations
/*
CameraPhone использует явное определение методов takePicture() и makeCall(),
что может быть полезно, если вы хотите точно контролировать поведение класса.
 */
//class CameraPhone(
//    private val camera: Camera,
//    private val phone: MobilePhone
//) : Camera, MobilePhone {
//    override fun takePicture() {
//        camera.takePicture()
//    }
//
//    override fun makeCall() {
//        phone.makeCall()
//    }
//}

/*
Здесь мы использовали делегирование свойств, чтобы избежать дублирования кода.
Вместо того, чтобы определять методы takePicture() и makeCall() вручную, мы делегируем
их реализацию объектам camera и phone, соответственно. Это позволяет нам избежать дублирования
кода и сделать класс CameraPhone более гибким для добавления новых реализаций в будущем.
 */
//class CameraPhone(
//    private val camera: Camera,
//    private val phone: MobilePhone
//) : Camera by camera, MobilePhone by phone

/*
Здесь мы определяем класс CameraPhone с использованием дженериков. Мы определяем два параметра типа T и U,
которые ограничены интерфейсами Camera и MobilePhone, соответственно. Это позволяет нам передавать любые объекты,
 которые реализуют соответствующие интерфейсы, в качестве аргументов при создании экземпляра класса CameraPhone.
 */

class CameraPhone<T : Camera, U : MobilePhone>(
    private val camera: T,
    private val phone: U
) : Camera by camera, MobilePhone by phone

/*
CameraPhone использует оператор vararg, чтобы позволить передавать любое количество объектов,
делегируя при этом поведение. Это может быть полезно, если вы хотите использовать CameraPhone с различными
устройствами, которые реализуют интерфейсы Camera и MobilePhone.
 */

//class CameraPhone(
//    vararg val devices: Any
//) : Camera, MobilePhone {
//    override fun takePicture() {
//        devices.filterIsInstance<Camera>().forEach { it.takePicture() }
//    }
//
//    override fun makeCall() {
//        devices.filterIsInstance<MobilePhone>().forEach { it.makeCall() }
//    }
//}

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

    val phone1 = Nokia()
    val camera1 = Canon()
    val camera2 = Canon()
    val phone2 = Nokia()
    val cameraPhone1 = CameraPhone(camera1, phone1)
    val anotherCameraPhone = CameraPhone(camera2, phone2)

    cameraPhone.takePicture()
    cameraPhone.makeCall()

    cameraPhone2.takePicture()
    cameraPhone2.makeCall()

    cameraPhone1.takePicture()
    anotherCameraPhone.makeCall()
}

/*
Таким образом, вы можете легко добавлять новые реализации Camera и MobilePhone,
не изменяя код CameraPhone.
 */