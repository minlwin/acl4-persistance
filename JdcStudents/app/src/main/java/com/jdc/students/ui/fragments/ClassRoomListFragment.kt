package com.jdc.students.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.students.R
import com.jdc.students.ui.adapter.ClassAdapter
import com.jdc.students.ui.adapter.CourseAdapter
import com.jdc.students.ui.model.ClassListModel
import com.jdc.students.ui.model.CourseListModel
import kotlinx.android.synthetic.main.fragment_course_list.*
import java.util.*

class ClassRoomListFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_class_room_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        super.init(Action.Date)

        val model by activityViewModels<ClassListModel>()
        val adapter = ClassAdapter()

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        model.list.observe(this, Observer {
            adapter.submitList(it)
        })

        model.from.value = null

        setDateSearchListener {
            model.from.value = it
        }
    }
}
