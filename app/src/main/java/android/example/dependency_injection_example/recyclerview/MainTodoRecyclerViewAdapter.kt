package android.example.dependency_injection_example.recyclerview

import android.example.dependency_injection_example.databinding.MainTodoItemBinding
import android.example.dependency_injection_example.model.data.TodoData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MainTodoRecyclerViewAdapter (var clickListener: MainTodoClickListener) : ListAdapter<TodoData,MainTodoRecyclerViewAdapter.ViewHolder>(MainTodoDiffUtils()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        // Binding Created
        val bindView = MainTodoItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(bindView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item!!, clickListener)
    }

    class ViewHolder(val binding:MainTodoItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: TodoData, clickListener: MainTodoClickListener?){
            binding.todoData=item
            binding.clickListener=clickListener

        }
    }

}

class MainTodoDiffUtils:DiffUtil.ItemCallback<TodoData>(){
    override fun areItemsTheSame(oldItem: TodoData, newItem: TodoData): Boolean {
        return  oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: TodoData, newItem: TodoData): Boolean {
        return oldItem==newItem
    }
}


class MainTodoClickListener(val clickListener:(todoData:TodoData)->Unit ) {
    fun onClick(todoData: TodoData)=clickListener(todoData)
}
