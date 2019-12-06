package practices.di.modules

import dagger.Module
import dagger.Provides
import practices.datastructure.SinglyLinkedList
import practices.datastructure.Tree

@Module
class DataStructureModule {

    @Provides
    fun provideTree() = Tree()

    @Provides
    fun provideSinglyLinkedList() = SinglyLinkedList()
}