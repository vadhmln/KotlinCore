import javax.naming.Context
import javax.swing.text.AttributeSet

fun main() {
    val zoro = Zoro(3)

}

class Zoro(age: Int) {

}

class PersonNext(firstName: String) {
    // Внутри класса можно использовать firstName напрямую,
    // но он не будет доступен как свойство класса.
    val name = firstName
}

open class ViewNext {
    constructor(ctx: Context)  {
    }

    constructor(ctx: Context, attr: AttributeSet)  {}
}

class myNextButton: ViewNext {
    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr)
}
