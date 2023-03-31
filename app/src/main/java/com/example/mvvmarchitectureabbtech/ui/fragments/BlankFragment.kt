package com.example.mvvmarchitectureabbtech.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mvvmarchitectureabbtech.R
import com.example.mvvmarchitectureabbtech.databinding.FragmentBlankBinding
import com.example.mvvmarchitectureabbtech.ui.customview.ProfileCustomView
import com.example.mvvmarchitectureabbtech.ui.main.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class BlankFragment : Fragment() {
    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    val customView = lazy { ProfileCustomView(requireContext(), null) }

    private val viewModel: UserViewModel by viewModels(ownerProducer = { requireActivity() })

     val scope = CoroutineScope(Dispatchers.IO)

    val coroutineJob= Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel.repository = LocalRepository(context as AbbActivity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_usersFragment)
        }

        scope.launch {
            viewModel.getNews()
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), "Testtt", Toast.LENGTH_SHORT).show()
            }
        }

        observeData()
        val name = arguments?.getString("userName") ?: "nullllll"
        Toast.makeText(requireActivity(), name, Toast.LENGTH_SHORT).show()
    }


    private fun observeData() {
//        viewModel.liveNewsData.observe(this, Observer { result ->
//            if(result!=null)
//            Log.d("resultss", result.totalResults.toString())
//        })

    }


    private fun addCustomView() {
        val layout = binding.mainBlank
        val set = ConstraintSet()
        set.clone(layout)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}