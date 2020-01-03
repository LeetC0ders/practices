package practices.di

import dagger.Component
import practices.questions.algo.BubbleSort
import practices.questions.algo.SelectionSort
import practices.questions.easy.*
import practices.questions.medium.*
import javax.inject.Singleton

@Singleton
@Component(dependencies = [DataStructureComponent::class])
interface AppComponent {

    // LeetCode questions
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

    fun provideMaximumSizeSubarraySumEqualsK(): MaximumSizeSubArraySumEqualsK

    fun provideBestTimeToBuyAndSellStock(): BestTimeToBuyAndSellStock

    fun provideVerifyingAnAlienDictionary(): VerifyingAnAlienDictionary

    fun provideMergeSortedArray(): MergeSortedArray

    fun provideAddStrings(): AddStrings

    fun provideTopKFrequentElements(): TopKFrequentElements

    fun provideKthLargestNumber(): KthLargestNumber

    fun provideMiddleOfLinkedList(): MiddleOfLinkedList

    fun provideSummaryRanges(): SummaryRanges

    // Algorithms
    fun provideSelectionSort(): SelectionSort

    fun provideBubbleSort(): BubbleSort
}
