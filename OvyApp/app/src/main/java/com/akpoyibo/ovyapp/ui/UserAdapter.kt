package com.akpoyibo.ovyapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akpoyibo.ovyapp.json.User

class UserAdapter(var users: List<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    class UserViewHolder (private val binding: UserItemHolder):
            RecyclerView.ViewHolder(binding.root){
                fun bindUser(user: User){
                    binding.apply{
                        txName.text = User.name
                        txEmail.text = user.email
                        txStreet.text = user.address.street

                    }
                }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemHolder.inflate(LayoutInflater.from(parent.context))
        return UserItemHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUser(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}