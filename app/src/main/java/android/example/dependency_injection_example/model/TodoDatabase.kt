package android.example.dependency_injection_example.model

import android.example.dependency_injection_example.model.data.TodoData
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoData::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao():TodoDao
}