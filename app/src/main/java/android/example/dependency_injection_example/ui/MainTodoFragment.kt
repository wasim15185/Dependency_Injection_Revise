package android.example.dependency_injection_example.ui

import android.example.dependency_injection_example.Demo
import android.example.dependency_injection_example.MainTodoViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.dependency_injection_example.R
import android.example.dependency_injection_example.Xyz
import android.example.dependency_injection_example.databinding.FragmentMainTodoBinding
import android.example.dependency_injection_example.model.data.TodoData
import android.example.dependency_injection_example.recyclerview.MainTodoClickListener
import android.example.dependency_injection_example.recyclerview.MainTodoRecyclerViewAdapter
import android.text.Editable
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainTodoFragment : Fragment() {

    private lateinit var binding:FragmentMainTodoBinding

    private val TAG = this::class.java.simpleName

    @Inject
     lateinit var str:String

     @Inject
     lateinit var demo:Demo

     @Inject
     lateinit var xyz: Xyz


     val viewModel :MainTodoViewModel by viewModels()


    var title=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_main_todo, container, false)

        binding.saveTodoBtn.setOnClickListener {
            val text = binding.addTodo.text.toString()
            if (text.isNotEmpty()) {
                viewModel.addTodo(TodoData(title = "Title ${++title}", description = text))
            }
            binding.addTodo.text="".toEditable()

        }

        val adapter = MainTodoRecyclerViewAdapter(MainTodoClickListener {

        })

        binding.mainTodoRecyclerView.adapter=adapter

        viewModel.allTask.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }




        return binding.root
    }


}

fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)
