package practices.di

import dagger.Component
import practices.datastructure.SinglyLinkedList
import practices.di.modules.DataStructureModule

@Component(modules = [DataStructureModule::class])
interface DataStructureComponent {

    fun provideSinglyLinkedList(): SinglyLinkedList

}