package android.example.dependency_injection_example.model

import android.example.dependency_injection_example.model.data.TodoData
import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table_of_di ORDER BY id ASC")
    fun getAllTasks(): LiveData<MutableList<TodoData>>

    @Query("SELECT * FROM todo_table_of_di WHERE id=:taskId")
    fun getSelectedTask(taskId:Int): Flow<TodoData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(todoData: TodoData)

    @Update
    suspend fun updateTask(todoData: TodoData)

    @Delete
    suspend fun deleteTask(todoData: TodoData)

    @Query("DELETE FROM todo_table_of_di")
    suspend fun deleteAllTask()


}