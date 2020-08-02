package com.example.mission04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Editable str;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText.setHint("입력하세요");
        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        final Button button2 = findViewById(R.id.button2);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //필터
                InputFilter[] filter = new InputFilter[1];
                filter[0] = new InputFilter.LengthFilter(80);
                editText.setFilters(filter);
                //화면에 띄우기
                int current = s.toString().getBytes().length;
                String txt = current+" /80 바이트";
                textView.setText(txt);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                str = editText.getText();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

    }




}
