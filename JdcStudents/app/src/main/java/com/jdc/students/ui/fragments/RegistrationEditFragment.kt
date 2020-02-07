package com.jdc.students.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.jdc.students.R
import com.jdc.students.databinding.FragmentRegistrationEditBinding
import com.jdc.students.ui.model.ClassListModel
import com.jdc.students.ui.model.RegistrationModel
import com.jdc.students.ui.utils.ClassArrayAdapter
import kotlinx.android.synthetic.main.fragment_registration_edit.*
import java.util.*

class RegistrationEditFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration_edit, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registrationModel by viewModels<RegistrationModel>()
        val classListModel by activityViewModels<ClassListModel>()

        classListModel.from.value = Date()

        val binding = FragmentRegistrationEditBinding.bind(view)

        binding.lifecycleOwner = this
        binding.model = registrationModel

        arguments?.getLong("id")?.also {
            registrationModel.id.value = it
        }

        ClassArrayAdapter.instance(requireContext(), registrationModel::setClass, classSelect).also { adapter ->
            classListModel.list.observe(this, Observer { adapter.submitList(it) })
        }
    }
}
