package practices.questions

const val EMPTY_SOLUTION_IN = "Empty solutionIn"

interface Solution<T, V> {

    fun getName(): String

    fun solve(solutionIn: T?): V

}