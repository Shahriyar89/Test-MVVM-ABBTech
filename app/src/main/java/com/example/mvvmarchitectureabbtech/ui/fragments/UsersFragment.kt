package com.example.mvvmarchitectureabbtech.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.model.User
import com.example.mvvmarchitectureabbtech.R
import com.example.mvvmarchitectureabbtech.databinding.FragmentUsersBinding
import com.example.mvvmarchitectureabbtech.ui.adapter.OnClickElementListener
import com.example.mvvmarchitectureabbtech.ui.adapter.UsersRecyclerAdapter
import com.example.mvvmarchitectureabbtech.ui.main.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment() {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserViewModel by viewModels(ownerProducer = { requireActivity() })
    private lateinit var adapter: UsersRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userList = viewModel.getAllUserFromDB()
        adapter = UsersRecyclerAdapter(userList)
        binding.apply {
            userRecyclerView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            userRecyclerView.adapter = adapter
        }
        adapter.onClickItem={
            val bundle= bundleOf()
            bundle.putString("userName",it.name)
            findNavController().navigate(R.id.blankFragment,bundle)

        }
//

        adapter.setAdapterClickListener(object :OnClickElementListener{
            override fun onClickListener(user: User) {
                val bundle= bundleOf()
            bundle.putString("userName",user.name)
            findNavController().navigate(R.id.blankFragment,bundle)
            }

        })


//        Toast.makeText(requireContext(), viewModel.getUserById().toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}