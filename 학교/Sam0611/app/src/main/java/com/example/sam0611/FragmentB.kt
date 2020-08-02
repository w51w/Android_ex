package com.example.sam0611

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat

/**
 * A simple [Fragment] subclass.
 */
class FragmentB (context : Context?) : LinearLayoutCompat(context){
    init {
        val view =
            LayoutInflater.from(context).inflate(R.layout.fragment_b, this, false)
        addView(view)
    }
}
