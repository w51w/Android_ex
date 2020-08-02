package com.example.fileosam0618

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPermission()
    }
    fun checkPermission(){
        if(ContextCompat.checkSelfPermission(this,permission[0])
        != PackageManager.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(this,permission[1])
        != PackageManager.PERMISSION_GRANTED){
            requestPermission()
        }else{
            startProcess()
        }
    }
    fun startProcess(){
        setContentView(R.layout.activity_main)

        val dirPath = filesDir.absolutePath
        val fileName = "NewFile.txt"
        val fileUtil = FileUtil()

        btnWrite.setOnClickListener {
            val content = et.text.toString().trim()
            if(content.length >0){
                Log.d("FileUtil", "dirPath=$dirPath")
                fileUtil.writeTextFile(dirPath,fileName,content)
                et.setText("")
            }
        }
        btnRead.setOnClickListener {
            val fullPath = "$dirPath/$fileName"
            Log.d("FileUtil", "fullPath = $fullPath")
            val content = fileUtil.readTextFile(fullPath)
            et.setText(content)
        }
    }
    fun getExternalDirectory() : String?{
        var directory:String? = null
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            directory = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)?.absolutePath
        }else{
            directory = "${Environment.getExternalStorageDirectory().absolutePath}/Documents"
        }
        Log.d("FileUtil","external dir=${directory}")

        return directory
    }
    fun requestPermission(){
        ActivityCompat.requestPermissions(this,permission,99)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 99){
            var check = true

            for(grant in grantResults){
                if(grant != PackageManager.PERMISSION_GRANTED){
                    check = false
                    break
                }
            }
            if(!check){
                Toast.makeText(this,"권한요청을 모두 승인해야지만 앱을 실행할 수 있습니다"
                , Toast.LENGTH_LONG).show()
                finish()
            }else{
                startProcess()
            }
        }
    }
}


