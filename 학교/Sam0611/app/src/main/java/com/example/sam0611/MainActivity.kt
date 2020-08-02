package com.example.sam0611

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val views = listOf(FragmentA(this),FragmentB(this),
            FragmentC(this),FragmentD(this))
        val adapter = FragmentAdapter()
        adapter.views = views
        viewPager.adapter = adapter
    }
}
