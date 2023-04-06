package com.example.mvvmarchitectureabbtech.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.User
import com.example.mvvmarchitectureabbtech.databinding.ItemRowBinding

class UsersRecyclerAdapter(val list: List<User>) :
    RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder>() {

    var onClickItem: ((User) -> Unit)? = null

    private var onElementClickLister :OnClickElementListener?=null

    private lateinit var binding: ItemRowBinding

    inner class ViewHolder(itemView: ItemRowBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(item: User) {
            binding.apply {
                uName.text = item.name
                uSurName.text = item.surname
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        binding = ItemRowBinding.inflate(inflate)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val selectedUser=list[position]
        holder.bind(selectedUser)

        holder.itemView.setOnClickListener {
            onClickItem?.invoke(selectedUser)
        }

        holder.itemView.setOnClickListener {
            onElementClickLister?.onClickListener(selectedUser)
        }
    }

     fun setAdapterClickListener(listener :OnClickElementListener?){
         onElementClickLister=listener
     }
}