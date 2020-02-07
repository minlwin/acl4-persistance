package com.jdc.students.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jdc.students.R
import com.jdc.students.databinding.ContentClassDetailsBinding
import com.jdc.students.ui.model.ClassDetailsModel
import kotlinx.android.synthetic.main.fragment_class_room_details.*

class ClassRoomDetailsFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_class_room_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val model by viewModels<ClassDetailsModel>()
        val binding = ContentClassDetailsBinding.bind(content)

        binding.lifecycleOwner = this
        binding.model = model

        arguments?.getLong("id")?.also {
            model.id.value = it
        }
    }

}
