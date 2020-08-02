package com.example.cjc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bmi.*

class activity_bmi : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        btn_result.setOnClickListener {
            val intent = Intent(this, activity_bmi_result::class.java)
            intent.putExtra("height1", et_height.text.toString())
            intent.putExtra("weight1", et_weight.text.toString())
            startActivity(intent)
        }

        btn_backToMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

}