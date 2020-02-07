package com.jdc.students.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.jdc.students.R
import com.jdc.students.databinding.ContentRegistrationBinding
import com.jdc.students.ui.model.RegistrationModel
import kotlinx.android.synthetic.main.fragment_regiistration_details.*

class RegistrationDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_regiistration_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model by viewModels<RegistrationModel>()
        val binding = ContentRegistrationBinding.bind(content)

        binding.lifecycleOwner = this
        binding.model = model
    }
}
