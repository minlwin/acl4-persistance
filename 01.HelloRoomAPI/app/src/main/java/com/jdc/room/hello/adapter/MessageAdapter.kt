package com.jdc.room.hello.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.room.hello.R
import com.jdc.room.hello.database.Message
import kotlinx.android.synthetic.main.item_message.view.*

class MessageAdapter() :
    ListAdapter<Message, MessageAdapter.MessageVH>(object : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Message, newItem: Message) = oldItem == newItem
    }) {

    class MessageVH(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MessageVH(
        LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
    )

    override fun onBindViewHolder(holder: MessageVH, position: Int) {
        getItem(position).also {
            holder.itemView.idNumber.text = it.id.toString()
            holder.itemView.message.text = it.data
        }
    }
}