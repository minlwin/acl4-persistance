package com.jdc.room.mappings.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.room.mappings.R
import com.jdc.room.mappings.db.entity.Post
import com.jdc.room.mappings.fragment.utils.dateFormat
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(private val listener:(Int)->Unit) : ListAdapter<Post, PostAdapter.PostVH>(
    object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem
    }
) {

    class PostVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostVH (
        LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
    )

    override fun onBindViewHolder(holder: PostVH, position: Int) {
        getItem(position).also {
            holder.itemView.title.text = it.title
            holder.itemView.content.text = it.contents
            it.creation?.also { date ->
                holder.itemView.creation.text = dateFormat.format(date)
            }

            holder.itemView.show.setOnClickListener { _->
                listener.invoke(it.id)
            }
        }

    }
}