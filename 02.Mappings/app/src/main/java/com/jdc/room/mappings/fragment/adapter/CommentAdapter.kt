package com.jdc.room.mappings.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.room.mappings.R
import com.jdc.room.mappings.db.entity.Comment
import com.jdc.room.mappings.fragment.utils.dateFormat
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentAdapter:ListAdapter<Comment, CommentAdapter.CommentVH>(
    object : DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment) =
            oldItem.postId == newItem.postId && oldItem.serialNumber == newItem.serialNumber

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment) =
            oldItem == newItem
    }
) {

    class CommentVH(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentVH (
        LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
    )

    override fun onBindViewHolder(holder: CommentVH, position: Int) {
        getItem(position).also {
            holder.itemView.comment.text = it.comment
            it.creation?.also { date ->
                holder.itemView.creation.text = dateFormat.format(date)
            }
        }
    }
}