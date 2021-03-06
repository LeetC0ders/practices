package practices.di

import dagger.Component
import practices.questions.easy.FindAllNumberDisappearedInArr
import practices.questions.easy.FizzBuzz
import practices.questions.easy.SplitStringToBalancedString
import practices.questions.easy.TwoSum
import practices.questions.medium.AddTwoNumbers
import practices.questions.medium.CountingBits
import practices.questions.medium.SummaryRanges
import practices.questions.medium.TopKFrequentWords
import javax.inject.Singleton

@Singleton
@Component(dependencies = [DataStructureComponent::class])
interface TestAppComponent {

    fun provideFizzBuzz(): FizzBuzz

    fun provideTwoSum(): TwoSum

    fun provideAddTwoNumbers(): AddTwoNumbers

    fun provideCountingBits(): CountingBits

    fun provideFindAllNumberDisappearedInArr(): FindAllNumberDisappearedInArr

    fun provideSummaryRanges(): SummaryRanges

    fun provideSplitStringToBalancedString(): SplitStringToBalancedString

    fun provideTopKFrequentWords(): TopKFrequentWords

}