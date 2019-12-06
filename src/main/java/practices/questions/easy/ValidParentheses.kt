package practices.questions.easy

import practices.questions.Solution
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/*
*
* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
* An input string is valid if:
*   - Open brackets must be closed by the same type of brackets.
*   - Open brackets must be closed in the correct order.
*   - Note that an empty string is also considered valid.
*
* Edge Cases:
* In: "([)]" Out: false
* In: "" Out: true
* */
@Singleton
class ValidParentheses @Inject constructor() : Solution<String, Boolean> {

    override fun getName() = "ValidParentheses"

    override fun solve(solutionIn: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /*
    * Runtime: 140 ms, faster than 77.05% of Kotlin online submissions for Valid Parentheses.
    * Memory Usage: 31.7 MB, less than 100.00% of Kotlin online submissions for Valid Parentheses.
    * */
    fun firstAttempt(solutionIn: String): Boolean {

        var rightBracketStack: Stack<Char> = Stack()

        for (charOfBracket in solutionIn) {
            try {
                when(charOfBracket) {
                    '(' -> rightBracketStack.add(charOfBracket)
                    '[' -> rightBracketStack.add(charOfBracket)
                    '{' -> rightBracketStack.add(charOfBracket)
                    '}' -> if (rightBracketStack.pop() != '{') return false
                    ']' -> if (rightBracketStack.pop() != '[') return false
                    ')' -> if (rightBracketStack.pop() != '(') return false
                }
            } catch (exception: Exception) {
                return false
            }
        }
        return rightBracketStack.isEmpty()
    }
}

//TODO: Use main as the base for unit test
//fun main() {
//    print(ValidParentheses().firstAttempt("]]"))
//}