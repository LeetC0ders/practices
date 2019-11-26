package practices.di

import dagger.Component
import practices.questions.easy.FizzBuzz
import practices.questions.easy.TwoSum
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    fun provideFizzBuzz() : FizzBuzz

    fun provideTwoSum() : TwoSum

}