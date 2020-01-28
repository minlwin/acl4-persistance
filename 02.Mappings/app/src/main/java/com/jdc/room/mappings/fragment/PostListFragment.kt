package com.jdc.room.mappings.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.jdc.room.mappings.R
import kotlinx.android.synthetic.main.fragment_post_list.*

class PostListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fab.setOnClickListener {
            it.findNavController().navigate(R.id.action_list_to_edit)
        }
    }
}
