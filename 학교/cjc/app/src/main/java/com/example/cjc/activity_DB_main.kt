package com.example.cjc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_sqlite.*

class activity_DB_main : AppCompatActivity(){
    val helper = SqliteHelper(this,"memo", 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        val adapter = RecyclerAdapter()
        adapter.helper = helper

        adapter.listData.addAll(helper.selectMemo())
        recyclerMemo.adapter = adapter
        recyclerMemo.layoutManager = LinearLayoutManager(this)

        buttonSave.setOnClickListener {
            if(editMemo.text.toString().isNotEmpty()){
                val memo = Memo(null , editMemo.text.toString(), System.currentTimeMillis())
                helper.insertMemo(memo)

                adapter.listData.clear()
                adapter.listData.addAll(helper.selectMemo())
                adapter.notifyDataSetChanged()
                editMemo.setText("")
            }
        }
    }
}