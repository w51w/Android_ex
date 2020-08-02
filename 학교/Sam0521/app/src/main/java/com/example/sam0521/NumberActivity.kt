package com.example.sam0521

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_number.*

class NumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)

        btn_click.setOnClickListener{
            val number =et_num.text.toString().toInt()

            when{
                number % 2 == 0  -> Toast.makeText(applicationContext,"${number}는 2의 배수입니다",Toast.LENGTH_SHORT).show()
                number % 3 == 0  -> Toast.makeText(applicationContext,"${number}는 3의 배수입니다",Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(applicationContext, "${number}는 2나 3의 배수가 아닙니다.",Toast.LENGTH_SHORT).show()
            }
        }

        btn_back.setOnClickListener{
            val intent =Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
