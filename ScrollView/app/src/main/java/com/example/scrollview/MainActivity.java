package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;
    int imageindex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView); //
        imageView = findViewById(R.id.imageView);   //레이아웃에 정의된 뷰 객체 참조
        scrollView.setHorizontalScrollBarEnabled(true);//수평 스크롤바 사용 기능 설정

        Resources res = getResources();//
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);//
        int bitmapWidth = bitmap.getIntrinsicWidth();//
        int bitmapHeight = bitmap.getIntrinsicHeight();//리소스의 이미지 참조

        imageView.setImageDrawable(bitmap);//
        imageView.getLayoutParams().width = bitmapWidth;//
        imageView.getLayoutParams().height = bitmapHeight;//이미지 리소스와 이미지 크기 설정
    }

    public void onButton1Clicked(View v){
        changeImage();
    }
    private void changeImage(){
        Resources res = getResources();//
        if(imageindex == 1) {
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);//
            imageindex = 0;
        }
        else if(imageindex == 0){
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);//
            imageindex = 1;
        }
        int bitmapWidth = bitmap.getIntrinsicWidth();//
        int bitmapHeight = bitmap.getIntrinsicHeight();//리소스의 이미지 참조

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;//
        imageView.getLayoutParams().height = bitmapHeight;//이미지 리소스와 이미지 크기 설정



    }
}
