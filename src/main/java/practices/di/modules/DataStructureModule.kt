package practices.di.modules

import dagger.Module
import dagger.Provides
import practices.datastructureimpl.StackImpl
import practices.datastructureutil.SinglyLinkedList
import practices.datastructureutil.Tree

@Module
class DataStructureModule {

    @Provides
    fun provideTree() = Tree()

    @Provides
    fun provideSinglyLinkedList() = SinglyLinkedList()

    @Provides
    fun provideStackImpl(): StackImpl<String> {
        return StackImpl(10)
    }
}