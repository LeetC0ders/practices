package practices.di

import dagger.Component
import practices.questions.easy.FizzBuzz
import practices.questions.easy.SplitStringToBalancedString
import practices.questions.easy.TwoSum
import practices.questions.medium.AddTwoNumbers
import practices.questions.medium.CountingBits
import practices.questions.medium.LongestSubstringWithoutRepeatingChars
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    fun provideFizzBuzz() : FizzBuzz

    fun provideTwoSum() : TwoSum

    fun provideAddTwoNumbers() : AddTwoNumbers

    fun provideLongestSubstringWithoutRepeatingCharacters() : LongestSubstringWithoutRepeatingChars

    fun provideSplitStringToBalancedString() : SplitStringToBalancedString

    fun provideCountingBits() : CountingBits
}