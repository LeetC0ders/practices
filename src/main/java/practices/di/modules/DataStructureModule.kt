package practices.di.modules

import dagger.Module
import dagger.Provides
import practices.datastructureutil.SinglyLinkedList
import practices.datastructureutil.Tree

@Module
class DataStructureModule {

    @Provides
    fun provideTree() = Tree()

    @Provides
    fun provideSinglyLinkedList() = SinglyLinkedList()
}