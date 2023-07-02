fun main() {
    /*
    Изолированные классы похожи на enum-классы: набор значений enum типа также ограничен,
    но каждая enum-константа существует только в единственном экземпляре, в то время как
    наследник изолированного класса может иметь несколько экземпляров, которые могут нести
    в себе какое-то состояние.
     */
}

//реализация иерархии классов для представления выражений (без sealed)
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }

//реализация иерархии классов для представления выражений (sealed)
sealed interface ExprSealed {
    data class NumSealed(val value: Int) : ExprSealed
    data class SumSealed(val left: ExprSealed, val right: ExprSealed) : ExprSealed
}

//выражения when + нет необходимости в ветке else
fun evalSealed(e: ExprSealed): Int =
    when (e) {
        is ExprSealed.NumSealed -> e.value
        is ExprSealed.SumSealed -> evalSealed(e.right) + evalSealed(e.left)
    }


