package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.startActivity

class resultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //anko 적용 전
        /*
        btn_result.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("height1", et_height.text.toString())
            intent.putExtra("weight1", et_weight.text.toString())
            startActivity(intent)
        }
         */
        btn_result.setOnClickListener {
            //anko 적용
            startActivity<MainActivity>(
                "height1" to et_height.text.toString(),
                "weight1" to et_weight.text.toString()
            )
        }
    }
}
