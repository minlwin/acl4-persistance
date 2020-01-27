package com.jdc.room.hello

import android.os.AsyncTask
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdc.room.hello.adapter.MessageAdapter
import com.jdc.room.hello.database.HelloDatabase
import com.jdc.room.hello.database.Message
import com.jdc.room.hello.database.MessageDao
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dao: MessageDao
    private lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dao = HelloDatabase.get(this).messageDao()
        adapter = MessageAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        SelectMessageTask(dao, adapter).execute()

        fab.setOnClickListener {
            InsertMessageTask(dao, adapter, messageInput).execute()
        }
    }

    class SelectMessageTask(private val dao: MessageDao, private val adapter: MessageAdapter) :
        AsyncTask<Void, Void, List<Message>>() {

        override fun doInBackground(vararg params: Void?): List<Message> {
            return dao.findAll()
        }

        override fun onPostExecute(result: List<Message>?) {
            adapter.submitList(result)
        }
    }

    class InsertMessageTask(private val dao: MessageDao, private val adapter: MessageAdapter, private val input: EditText) :
        AsyncTask<Void, Void, List<Message>>() {

        private lateinit var data:String

        override fun onPostExecute(result: List<Message>?) {
            adapter.submitList(result)
            input.setText("")
        }

        override fun onPreExecute() {
            data = input.text.toString()
        }

        override fun doInBackground(vararg params: Void?): List<Message> {
            dao.create(Message(data = data))
            return dao.findAll()
        }
    }
}
