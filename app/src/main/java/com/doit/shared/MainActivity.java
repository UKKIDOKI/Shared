package com.doit.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
/*
SharedPreferences는 (설정에서 자주사용 ex)
데이터를 파일로 저장함
파일은 앱데이터 내에 저장되기에 앱이 삭제되면 데이터도 삭제됨
클래스로 만들어서 사용하기 좋음

저장된 파일의 위치는 data/data/(package_name)/shared_prefs/SharedPreference
출처 https://re-build.tistory.com/37 참고하기
아래는 MainActivity의 있는 SharedPreferences를 클래스화 하여 작성한 코드
 */
public class MainActivity extends AppCompatActivity {
    EditText et_save;    // 사용할 변수선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_save = findViewById(R.id.et_save);


        String value = PreferenceManager.getString(this,"rebuild");
        et_save.setText(value); // EditText에 받아온값 저장


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        String value = et_save.getText().toString(); // EditText에 입력된 데이터를 문자열형태로 가져와 문자열 변수에 저장
        PreferenceManager.setString(this,"rebuild",value);
    }

}