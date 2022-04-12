package com.doit.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_save = findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0); //
        String value = sharedPreferences.getString("key","");
        et_save.setText(value); // EditText에 받아온값 저장


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit(); // 저장할때 필수
        String value = et_save.getText().toString(); // EditText에 입력된 데이터를 문자열형태로 가져와 문자열 변수에 저장
        editor.putString("key", value); // 에디터안에 문자열 데이터 저장  키값과, 벨류
        editor.commit();  // 저장
    }

}