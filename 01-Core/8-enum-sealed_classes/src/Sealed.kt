import com.sun.source.tree.BinaryTree

fun main() {

     // Изолированные классы похожи на enum-классы: набор значений enum типа также ограничен,
     // но каждая enum-константа существует только в единственном экземпляре, в то время как
     // наследник изолированного класса может иметь несколько экземпляров, которые могут нести
     // в себе какое-то состояние.

    // используем с when
    when (val result: Result = getSomeData()) {
        is Result.Success -> handleSuccess(result.data)
        is Result.Failure -> handleFailure(result.exception)
        else -> {}
    }
}

// sealed (изолированный) имеет тип из ограниченного набора,
// который известен при компиляции
// сторонние клиенты не могут расширить sealed в своем коде
sealed class Result {
    class Success(val data: String) : Result()
    class Failure(val exception: Throwable) : Result()
}

fun handleFailure(exception: Throwable) {
    TODO("Not yet implemented")
}

fun handleSuccess(data: String) {
    TODO("Not yet implemented")
}

fun getSomeData(): Result {
    TODO("Not yet implemented")
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

//Alternatively, you could use an abstract class:
abstract class ResultAbstract {
    class Success(val data: String) : ResultAbstract()
    class Failure(val exception: Throwable) : ResultAbstract()
}

sealed interface ResultSealed {
    class Success(val data: String) : Result()
    class Failure(val exception: Throwable) : Result()
}

sealed class MathOperation {
    class Plus(val left: Int, val right: Int) : MathOperation()
    class Minus(val left: Int, val right: Int) : MathOperation()
    class Times(val left: Int, val right: Int) : MathOperation()
    class Divide(val left: Int, val right: Int) : MathOperation()
}

sealed interface Tree {
    class Leaf(val value: Any?) : Tree
    class Node(val left: Tree, val right: Tree) : Tree
}

sealed interface Either<out L, out R> {
    class Left<out L>(val value: L) : Either<L, Nothing>
    class Right<out R>(val value: R) : Either<Nothing, R>
}

sealed interface AdView {
    object FacebookAd : AdView
    object GoogleAd : AdView
    class OwnAd(val text: String, val imgUrl: String) : AdView
}

// new methods to sealed elements using extension functions
fun Tree.height(): Int = when (this) {
    is Tree.Leaf -> 1
    is Tree.Node -> maxOf(this.left.height(), this.right.height())
}

sealed interface Parent {
    object A : Parent
    object B : Parent
    object C : Parent
}


