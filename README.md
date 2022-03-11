## Dependency Injection Revise

### What is 'Module' ?

<p> <b> Ans:- </b> Basically , Module is a <b>Class</b> . This class can be <b> Normal-class, Abstract-class, Singleton-class </b>. You can say Module is  a container for dependencies .
 Module lives specific amount time inside android app . Inside this Module we can define dependencies (like : Retrofit Object , Room Object etc.)

<b> We know Module is like a container of dependencies . So, Inside Module , we can define all type of objects  1. Which Code we don't own (eg: Library) 2. Interface 3. And Also my Custom Object .</b>

 In Dagger-Hilt we can scope our dependencies , with some annotation, we can restrict the life of dependencies of Module in Android Application
 means 
 ( eg : 
     1. If 'Module' annotated with 'SingletonComponent' then all dependencies of Module live as long as Our 'Application' live . 
     2. If 'Module' annotated with 'ActivityComponent' then all then all dependencies of Module live as long as Our 'Activity' live 
     3. If 'Module' annotated with 'ViewModelComponent' then all then all dependencies of Module live as long as Our 'ViewModel' live 
      etc ...
 )
</p>
    
### What is the work of '@Inject' annotation ? 

=> Basically , we can use "@Inject" annotation in two places . **1. Inside Constructor** , **2. Field Injection** 
> Note : Dagger-Hilt inject dependencies inside a variable depends on Type of variable . 
> If **variable-Type** dependency is **available** inside Dagger-Hilt then sure it will inject that 
> dependency inside that variable but If **variable-Type** dependency is **Not available**  inside Dagger-Hilt
> then Dagger-Hilt throw Error . 


#### Inside Constructor : 
If I write `@Inject` annotation in-front of constructor of `any Class` . Then Dagger-Hilt , get ability to create class automatically and if any variable needs this type then Dagger-Hilt Inject that type dependency.

```
class Demo @Inject constructor() { //  <==  See Here I write `@Inject` infront of constructor that means 1. Dagger-Hilt can 
                                  // create object of this class automatically 2. And Dagger-Hilt can inject dependency anywhare without Module
    private val TAG = this::class.java.simpleName
    fun call(){
        println("I am from $TAG class")
    }
}

class Xyz @Inject constructor( private val demo: Demo ){ //  <==  See Here I write `@Inject` infront of constructor that means Dagger Hilt will create 
            // Object this class automatically without creating a module . but problem is constructor required object of Demo class how chould Dagger-Hilt create instance of Xyz class ?
            // Ans :- We know When we write `@Inject` infront of constructor that means 1. Dagger-Hilt can  create object of this class automatically 
            // 2. And Dagger-Hilt can inject dependency anywhare without Module 
            // Here Demo class constructor annotated with `@Inject` so automaticlly object of "Demo" class will created and automatically
             // dependency of "Demo" class is avalible in Dagger-Hilt and if any where that dependency will need that it will provided by deggaer

}



@AndroidEntryPoint
class MainTodoFragment : Fragment() {
      @Inject
     lateinit var demo:Demo // <- Field Injection

     @Inject
     lateinit var xyz: Xyz // <- Field Injection

}


```
