package com.example.cjc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bmi_result.*
import java.math.RoundingMode
import java.text.DecimalFormat

class activity_bmi_result : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_result)

        var height = intent.getStringExtra("height1").toInt()
        var weight = intent.getStringExtra("weight1").toInt()

        //BMI 계산
        var bmi = weight/Math.pow(height/100.0, 2.0)

        //반올림
        var DF = DecimalFormat("#.###")
        DF.roundingMode = RoundingMode.HALF_DOWN
        bmi = DF.format(bmi).toDouble()

        //bMI 결과 표시
        when{
            bmi > 35 ->bmi_result_tv.text="고도 비만"
            bmi > 30 ->bmi_result_tv.text = "2단계 비만"
            bmi > 25 ->bmi_result_tv.text = "1단계 비만"
            bmi > 23 ->bmi_result_tv.text = "과체중"
            bmi > 18.5 ->bmi_result_tv.text = "정상"
            else -> bmi_result_tv.text = "저체중"
        }

        when{
            bmi > 23 -> imageView.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp)
            bmi > 18.5 ->imageView.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp)
            else -> imageView.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp)
        }

        Toast.makeText(this,"BMI : $bmi", Toast.LENGTH_LONG).show()


        btn_back.setOnClickListener {
            val intent = Intent(this, activity_bmi::class.java)
            startActivity(intent)
        }
    }
}