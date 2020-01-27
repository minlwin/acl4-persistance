package com.jdc.room.hello

import android.os.Bundle
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

        adapter.submitList(dao.findAll())

        fab.setOnClickListener {
            dao.create(Message(data = messageInput.text.toString()))
            adapter.submitList(dao.findAll())
            messageInput.setText("")
        }
    }

}
