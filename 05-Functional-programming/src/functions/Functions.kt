package functions

// принимает два параметра с типами функций (Int) -> Int
// и возвращает функцию того же типа
fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { x -> f(g(x)) }

