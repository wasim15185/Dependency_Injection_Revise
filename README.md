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
