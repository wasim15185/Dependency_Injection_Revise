package android.example.dependency_injection_example

import javax.inject.Inject

class Demo @Inject constructor() {
    private val TAG = this::class.java.simpleName
    fun call(){
        println("I am from $TAG class")
    }
}


class Xyz @Inject constructor(private val demo: Demo){



}