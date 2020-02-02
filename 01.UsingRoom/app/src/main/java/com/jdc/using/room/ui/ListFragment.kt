package com.jdc.using.room.ui


import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.jdc.using.room.R
import com.jdc.using.room.db.Student
import com.jdc.using.room.db.StudentDB
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = StudentAdapter()
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        StudentLoadTask(adapter).execute()
    }

    private inner class StudentLoadTask(private val adapter: StudentAdapter):AsyncTask<Void, Void, List<Student>>() {

        override fun doInBackground(vararg params: Void?): List<Student> {
            val dao = StudentDB.getDatabase(requireContext()).studentDao()
            return dao.getAll()
        }

        override fun onPostExecute(result: List<Student>?) {
            result?.also {
                adapter.submitList(it)
            }
        }
    }
}
