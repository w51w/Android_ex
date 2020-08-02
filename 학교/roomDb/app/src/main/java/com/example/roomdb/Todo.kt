package com.example.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (val title : String){
    @PrimaryKey(autoGenerate = true) var id: Int =0
}