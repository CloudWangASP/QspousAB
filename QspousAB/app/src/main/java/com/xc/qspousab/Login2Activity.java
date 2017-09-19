package com.xc.qspousab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.xc.qspousab.adapter.DetailAdapter;


public class Login2Activity extends AppCompatActivity {
    ListView detail;

    DetailAdapter detailAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        detail = (ListView) findViewById(R.id.detail);
        detailAdapter = new DetailAdapter(Login2Activity.this);
        detail.setAdapter(detailAdapter);
    }
}
