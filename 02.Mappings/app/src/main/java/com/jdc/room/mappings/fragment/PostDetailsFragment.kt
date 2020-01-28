package com.jdc.room.mappings.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.jdc.room.mappings.R
import kotlinx.android.synthetic.main.fragment_post_details.*

class PostDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        listBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_details_to_list)
        }
    }

}
