package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        db.todoDao().getAll().observe(this, Observer{
            result_txt.text = it.toString()
        })

        add_btn.setOnClickListener {
            db.todoDao().insertAll(Todo(todo_edit.text.toString()))
            //result_txt.text = db.todoDao().getAll().toString()
        }
    }
}
