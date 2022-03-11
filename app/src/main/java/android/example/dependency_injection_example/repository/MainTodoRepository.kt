package android.example.dependency_injection_example.repository

import android.example.dependency_injection_example.model.TodoDao
import android.example.dependency_injection_example.model.data.TodoData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainTodoRepository@Inject constructor(private val todoDao: TodoDao) {

    val gatAllTasks = todoDao.getAllTasks()

    fun getSelectedTask(taskId:Int): Flow<TodoData> {
        return todoDao.getSelectedTask(taskId)
    }

    suspend fun addTask(todoTask: TodoData){
        todoDao.addTask(todoTask)
    }

    suspend fun updateTask(todoTask: TodoData){
        todoDao.updateTask(todoTask)
    }

    suspend fun deleteTask(todoTask: TodoData){
        todoDao.deleteTask(todoTask)
    }

    suspend fun deleteAllTask(){
        todoDao.deleteAllTask()
    }




}