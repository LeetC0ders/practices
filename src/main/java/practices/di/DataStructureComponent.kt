package practices.di

import dagger.Component
import practices.datastructureimpl.StackImpl
import practices.datastructureutil.SinglyLinkedList
import practices.di.modules.DataStructureModule

@Component(modules = [DataStructureModule::class])
interface DataStructureComponent {

    fun provideSinglyLinkedList(): SinglyLinkedList

    fun provideStackImpl(): StackImpl<String>

}