package android.example.dependency_injection_example.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * What is Module ?
 *
 * Ans:- Basically , Module is a Object . You can say Module is  a container for dependencies .
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

@Module()
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    /**
     * Inside Module , We have to specify a Blue-Print .
     */


}