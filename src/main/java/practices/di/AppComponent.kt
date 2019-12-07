package practices.di

import dagger.Component
import practices.questions.easy.*
import practices.questions.medium.AddTwoNumbers
import practices.questions.medium.BinaryTreeLevelOrderTraversal
import practices.questions.medium.CountingBits
import practices.questions.medium.LongestSubstringWithoutRepeatingChars
import javax.inject.Singleton

@Singleton
@Component(dependencies = [DataStructureComponent::class])
interface AppComponent {

    fun provideFizzBuzz() : FizzBuzz

    fun provideTwoSum() : TwoSum

    fun provideAddTwoNumbers() : AddTwoNumbers

    fun provideLongestSubstringWithoutRepeatingCharacters() : LongestSubstringWithoutRepeatingChars

    fun provideSplitStringToBalancedString() : SplitStringToBalancedString

    fun provideCountingBits() : CountingBits

    fun provideFindAllNumbersDisappearedInArr() : FindAllNumberDisappearedInArr

    fun provideBinaryTreeLevelOrderTraversal() : BinaryTreeLevelOrderTraversal

    fun provideReverseLinkedList() : ReverseLinkedList

    fun provideInvertBinaryTree() : InvertBinaryTree

    fun provideValidParentheses() : ValidParentheses

    fun provideMergeTwoSortedList() : MergeTwoSortedList
}
