package android.example.dependency_injection_example.model.data

import android.example.dependency_injection_example.utils.Constant.DATABASE_TABLE
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = DATABASE_TABLE)
data class TodoData (
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String,
    val description:String,
)