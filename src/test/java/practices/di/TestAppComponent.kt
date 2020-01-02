package practices.di

import dagger.Component
import practices.questions.easy.FindAllNumberDisappearedInArr
import practices.questions.easy.FizzBuzz
import practices.questions.easy.TwoSum
import practices.questions.medium.AddTwoNumbers
import practices.questions.medium.CountingBits
import javax.inject.Singleton

@Singleton
@Component(dependencies = [DataStructureComponent::class])
interface TestAppComponent {

    fun provideFizzBuzz(): FizzBuzz

    fun provideTwoSum(): TwoSum

    fun provideAddTwoNumbers(): AddTwoNumbers

    fun provideCountingBits(): CountingBits

    fun provideFindAllNumberDisappearedInArr(): FindAllNumberDisappearedInArr

}