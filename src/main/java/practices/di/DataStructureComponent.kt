package practices.di

import dagger.Component
import practices.datastructureutil.SinglyLinkedList
import practices.di.modules.DataStructureModule

@Component(modules = [DataStructureModule::class])
interface DataStructureComponent {

    fun provideSinglyLinkedList(): SinglyLinkedList

}