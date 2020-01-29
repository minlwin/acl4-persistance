package com.jdc.room.mappings.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.jdc.room.mappings.R
import com.jdc.room.mappings.db.PostDatabase
import com.jdc.room.mappings.db.entity.Comment
import com.jdc.room.mappings.fragment.adapter.CommentAdapter
import com.jdc.room.mappings.fragment.utils.dateFormat
import kotlinx.android.synthetic.main.fragment_post_details.*
import java.util.*

class PostDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val postId = arguments?.getInt("postId")
        val postDao = PostDatabase.database(requireContext()).postDao()
        val commentDao = PostDatabase.database(requireContext()).commentDao()

        recycler.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CommentAdapter().also {
            recycler.adapter = it
        }

        val postWithComments = postId?.let {
            val postWithComments = postDao.findById(it.toInt())

            title.text = postWithComments.post.title
            content.text = postWithComments.post.contents
            creation.text = dateFormat.format(postWithComments.post.creation)

            adapter.submitList(postWithComments.comments)

            postWithComments
        }

        listBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_details_to_list)
        }

        commentBtn.setOnClickListener { _ ->
            postWithComments?.also {
                val newComment = Comment(
                    it.post.id,
                    it.comments.size + 1,
                    comment.text.toString(),
                    Date()
                )

                commentDao.create(newComment)

                adapter.submitList(commentDao.findByPostId(postWithComments.post.id))

                comment.setText("")
            }
        }
    }

}
