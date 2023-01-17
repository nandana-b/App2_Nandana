package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  lateinit var  todoAdapter:ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button=findViewById<Button>(R.id.button3)
        button.setOnClickListener {
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        val button5=findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            val intent= Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        val button4=findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            val intent= Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }


        todoAdapter= ToDoAdapter(mutableListOf())

        rvToDoItems.adapter=todoAdapter
        rvToDoItems.layoutManager=LinearLayoutManager(this)

        btnAdd.setOnClickListener{
            val todoTitle=etToDoTitle.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo =ToDo(todoTitle)
                todoAdapter.addToDo(todo)
                etToDoTitle.text.clear()
            }
        }
        btnDelete.setOnClickListener {
            todoAdapter.deleteDone()
        }
    }
}