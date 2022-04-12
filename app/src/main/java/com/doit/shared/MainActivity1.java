package com.doit.shared;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/*
SharedPreferences는
데이터를 파일로 저장함
파일은 앱데이터 내에 저장되기에 앱이 삭제되면 데이터도 삭제됨
클래스로 만들어서 사용하기 좋음

저장된 파일의 위치는 data/data/(package_name)/shared_prefs/SharedPreference
출처 https://re-build.tistory.com/37 참고하기
 */
public class MainActivity1 extends AppCompatActivity {
    EditText et_save;    // 사용할 변수선언
    String shared = "file"; //

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