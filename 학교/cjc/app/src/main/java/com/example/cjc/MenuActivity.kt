package com.example.cjc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        menu_btn.setOnClickListener {
            val intent = Intent(this, activity_cjc::class.java)
            startActivity(intent)
        }

        menu_btn2.setOnClickListener {
            val intent = Intent(this, activity_bmi::class.java)
            startActivity(intent)
        }

        menu_btn3.setOnClickListener {
            val intent = Intent(this, activity_DB_main::class.java)
            startActivity(intent)
        }

        btn_backToEntry.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}