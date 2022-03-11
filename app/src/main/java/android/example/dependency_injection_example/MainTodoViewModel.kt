package android.example.dependency_injection_example

import android.example.dependency_injection_example.model.data.TodoData
import android.example.dependency_injection_example.repository.MainTodoRepository
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MainTodoViewModel @Inject constructor(val repository: MainTodoRepository) : ViewModel() {

    private val job= Job()

    private val backgroundScope= CoroutineScope(Dispatchers.IO+job)
    private val uiScope= CoroutineScope(Dispatchers.Main+job)


    val allTask = repository.gatAllTasks

    fun addTodo(todo:TodoData){
        backgroundScope.launch {
            repository.addTask(todo)
        }
    }





}