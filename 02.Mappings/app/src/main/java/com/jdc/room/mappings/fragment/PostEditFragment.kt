package com.jdc.room.mappings.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.jdc.room.mappings.R
import com.jdc.room.mappings.db.PostDatabase
import com.jdc.room.mappings.db.entity.Post
import kotlinx.android.synthetic.main.fragment_post_edit.*
import java.util.*

class PostEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_edit, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val dao = PostDatabase.database(requireContext()).postDao()

        button2.setOnClickListener { _ ->

            val post = Post(
                title = title.text.toString(),
                contents = content.text.toString(),
                creation = Date()
            )

            val postId = dao.create(post)

            view.findNavController().navigate(R.id.action_edit_to_details, Bundle().also {
                it.putInt("postId", postId.toInt())
            })
        }
    }
}
