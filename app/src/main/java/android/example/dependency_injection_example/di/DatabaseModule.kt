package android.example.dependency_injection_example.di

import android.example.dependency_injection_example.Demo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * What is Module ?
 *
 * Ans:- Basically , Module is a Object . You can say Module is  a container for dependencies .
 * We know Module is like a container of dependencies . So, Inside Module , we can define all type of objects  1. Which Code we don't own (eg: Library) 2. Interface 3. And Also my Custom Object
 * Module lives specific amount time inside android app . Inside this Module we can define dependencies (like : Retrofit Object , Room Object etc.)
 *
 * In Dagger-Hilt we can scope our dependencies , with some annotation, we can restrict the life of dependencies of Module in Android Application
 * means (eg : 1. If 'Module' annotated with 'SingletonComponent' then all dependencies of Module live as long as Our 'Application' live .
 * 2. If 'Module' annotated with 'ActivityComponent' then all then all dependencies of Module live as long as Our 'Activity' live .
 * 3. If 'Module' annotated with 'ViewModelComponent' then all then all dependencies of Module live as long as Our 'ViewModel' live .
 * etc .
 * )
 *
 */

@Module() // <== This annotation indicates 'DatabaseModule' is Module in App .
@InstallIn(SingletonComponent::class) /* <== This for scope for module eg : 'SingletonComponent' means then all dependencies of Module available to whole application ,
                                                that means all dependencies of Module live as long as Our 'Application' live . */
object DatabaseModule {
    /**
     * Inside Module , We have to specify a Blue-Print .
     */

    @Singleton
    @Provides
    fun provideGetString():String=" I am from Database Module "


}

