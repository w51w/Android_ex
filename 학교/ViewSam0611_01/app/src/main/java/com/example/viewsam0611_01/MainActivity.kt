package com.example.viewsam0611_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    var check = false;
    var check2 = false;
    var check3 = false;
    var check4 = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread(start = true){
            for(i in 0 until 100){
                Thread.sleep(1000)
                runOnUiThread {
                    tv_progreesResult.text = "${i+1}"
                }
            }
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rdApple -> tv_radioResult.text = "사과"
                R.id.rdBanana -> tv_radioResult.text = "바나나"
                R.id.rdOrange -> tv_radioResult.text = "오렌지"
            }
        }

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            check = isChecked
            printCheckedItems()
        }
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            check2 = isChecked
            printCheckedItems()
        }
        checkBox3.setOnCheckedChangeListener { buttonView, isChecked ->
            check3 = isChecked
            printCheckedItems()
        }
        checkBox4.setOnCheckedChangeListener { buttonView, isChecked ->
            check4 = isChecked
            printCheckedItems()
        }
    }
    fun printCheckedItems(){
        var result =""
        if(check) result = "영화"
        if(check2) result += " 여행"
        if(check3) result += " 자전거"
        if(check4) result += " 음악"

        tv_radioResult.text = "${result}(이)가 선택되었습니다."
    }


}
