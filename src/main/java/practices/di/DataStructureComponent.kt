package practices.di

import dagger.Component
import practices.questions.medium.AddTwoNumbers

@Component
interface DataStructureComponent {

    fun inject(addTwoNumbers: AddTwoNumbers)

}