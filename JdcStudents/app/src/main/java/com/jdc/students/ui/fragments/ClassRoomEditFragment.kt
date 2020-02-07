package com.jdc.students.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jdc.students.R
import com.jdc.students.databinding.FragmentClassRoomEditBinding
import com.jdc.students.ui.converter.datepicker
import com.jdc.students.ui.model.ClassEditModel
import com.jdc.students.ui.model.CourseListModel
import com.jdc.students.ui.utils.CourseArrayAdapter
import kotlinx.android.synthetic.main.fragment_class_room_edit.*

class ClassRoomEditFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_class_room_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        datepicker(requireContext()) { dateInput }

        val classEditModel by viewModels<ClassEditModel>()
        val coursesModel by activityViewModels<CourseListModel>()

        val binding = FragmentClassRoomEditBinding.bind(view)
        binding.lifecycleOwner = this
        binding.model = classEditModel

        classEditModel.title.observe(this, Observer {
            toolbar.title = it
        })

        arguments?.getLong("id")?.also {
            classEditModel.id.value = it
        }

        CourseArrayAdapter.instance(requireContext(), classEditModel::setCourse, courseSelect).also { adapter ->
            coursesModel.list.observe(this, Observer { adapter.submitList(it) })
        }
    }
}
