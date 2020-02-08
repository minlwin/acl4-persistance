package com.jdc.using.room.ui


import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController

import com.jdc.using.room.R
import com.jdc.using.room.db.Student
import com.jdc.using.room.db.StudentDB
import kotlinx.android.synthetic.main.fragment_edit.*

class EditFragment : Fragment() {

    private lateinit var navController:NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        navController = view.findNavController()

        button.setOnClickListener {

            val task = CreateTask { view.findNavController() }

            val student = Student(
                name = name.text.toString(),
                phone = phone.text.toString(),
                email = email.text.toString(),
                address = address.text.toString()
            )

            task.execute(student)
        }
    }

    private inner class CreateTask():AsyncTask<Student, Void, Void?>() {

        private val dao = StudentDB.getDatabase(requireContext()).studentDao()

        override fun doInBackground(vararg params: Student?): Void? {
            params?.also {
                for(student in it) {
                    student?.apply {
                        dao.create(this)
                    }
                }
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            navController.navigate(R.id.action_edit_to_list)
        }
    }
}
