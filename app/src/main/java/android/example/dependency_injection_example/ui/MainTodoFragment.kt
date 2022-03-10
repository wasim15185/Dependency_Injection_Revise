package android.example.dependency_injection_example.ui

import android.example.dependency_injection_example.Demo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.dependency_injection_example.R
import android.example.dependency_injection_example.databinding.FragmentMainTodoBinding
import android.util.Log
import androidx.databinding.DataBindingUtil
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_main_todo, container, false)





        return binding.root
    }


}