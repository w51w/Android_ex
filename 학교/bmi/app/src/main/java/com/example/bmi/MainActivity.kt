package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.math.RoundingMode
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            bmi > 35 ->tv_result.text="고도 비만"
            bmi > 30 ->tv_result.text = "2단계 비만"
            bmi > 25 ->tv_result.text = "1단계 비만"
            bmi > 23 ->tv_result.text = "과체중"
            bmi > 18.5 ->tv_result.text = "정상"
            else -> tv_result.text = "저체중"
        }

        when{
            bmi > 23 -> imageView.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp)
            bmi > 18.5 ->imageView.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp)
            else -> imageView.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp)
        }
        //anko 적용 전
        //Toast.makeText(this,"BMI : $bmi", Toast.LENGTH_LONG).show()
        //anko 적용
        toast("키: $height, 몸무게: $weight,BMI: $bmi")

        btn_back.setOnClickListener {
            val intent = Intent(this, resultActivity::class.java)
            startActivity(intent)
        }
    }
}
