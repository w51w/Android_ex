package com.example.dbsam0625

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myHelper: myDBHelper
    lateinit var edtName: EditText
    lateinit var edtNumber: EditText
    lateinit var edtNameReuslt: EditText
    lateinit var edtNumberResult: EditText
    lateinit var btnInit: Button
    lateinit var btnInsert: Button
    lateinit var btnUpdate: Button
    lateinit var btnDelete: Button
    lateinit var btnSelect: Button
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        //supportActionBar!!.setIcon(R.drawable.firefox)
        title ="가수 그룹 관리 DB"

        edtName = findViewById<EditText>(R.id.edtName)
        edtNumber = findViewById<EditText>(R.id.edtNumber)
        edtNameReuslt = findViewById<EditText>(R.id.edtNameResult)
        edtNumberResult = findViewById<EditText>(R.id.edtNumberResult)

        btnInit = findViewById<Button>(R.id.btnInit)
        btnInsert = findViewById<Button>(R.id.btnInsert)
        btnUpdate = findViewById<Button>(R.id.btnUpdate)
        btnDelete = findViewById<Button>(R.id.btnDelete)
        btnSelect = findViewById<Button>(R.id.btnSelect)

        myHelper = myDBHelper(this)
        btnInit.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            myHelper.onUpgrade(sqlDB, 1, 2)
            sqlDB.close()
        }
        btnInsert.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO groupTBL VALUES('"
            + edtName.text.toString() + "',"
            + edtNumber.text.toString() + ");")
            sqlDB.close()
            Toast.makeText(applicationContext, "입력됨", Toast.LENGTH_SHORT).show()
            btnSelect.callOnClick()
        }

        btnUpdate.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            if(edtName.text.toString() !== ""){
                sqlDB.execSQL("UPDATE groupTBL SET gNumber ="
                + edtNumber.text+ " WHERE gName = '"
                + edtName.text.toString() + "';")
            }
            sqlDB.close()

            Toast.makeText(applicationContext, "수정됨", Toast.LENGTH_SHORT).show()
            btnSelect.callOnClick()
        }

        btnDelete.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            if(edtName.text.toString() !== ""){
                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName ='"
                        + edtName.text.toString() + "';")
            }
            sqlDB.close()

            Toast.makeText(applicationContext, "삭제됨", Toast.LENGTH_SHORT).show()
            btnSelect.callOnClick()
        }

        btnSelect.setOnClickListener {
            sqlDB = myHelper.readableDatabase
            var cursor: Cursor
            cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;" , null)

            var strNames = "그룹이름" + "\r\n" + "-------" + "\r\n"
            var strNumbers = "인원" + "\r\n" + "-------" + "\r\n"

            while(cursor.moveToNext()){
                strNames += cursor.getString(0) + "\r\n"
                strNumbers += cursor.getString(1) + "\r\n"
            }

            edtNameReuslt.setText(strNames)
            edtNumberResult.setText(strNumbers)

            cursor.close()
            sqlDB.close()
        }
    }
    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1){
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL("CREATE TABLE groupTBL(gName CHAR(20) PRIMARY KEY, gNumber INTEGER);")
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL")
            onCreate(db)
        }
    }
}
