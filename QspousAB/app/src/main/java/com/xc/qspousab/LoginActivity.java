package com.xc.qspousab;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button yuangong;
    Button boss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        yuangong = (Button) findViewById(R.id.yuangong);
        boss = (Button) findViewById(R.id.boss);
        //创建逻辑控件与页面空间的关联
        yuangong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, Login2Activity.class);
                startActivity(intent);
            }
        });
        boss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, Login2Activity.class);
                startActivity(intent);
            }
        });
    }


}
