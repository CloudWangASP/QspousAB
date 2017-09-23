package com.xc.qspousab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.xc.qspousab.adapter.DetailAdapter;

import java.util.ArrayList;


public class RecordActivity extends AppCompatActivity {
    ListView detail;

    DetailAdapter detailAdapter;

    ArrayList<Double> data = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recode);
        detail = (ListView) findViewById(R.id.detail);

        //模拟数据
        data.add(80.6);
        data.add(-20.0);
        data.add(24671.5);
        data.add(543.5);
        data.add(-510.0);
        data.add(-180.8);
        data.add(484.0);
        data.add(340.8);
        data.add(880.3);
        data.add(-124.5);

        detailAdapter = new DetailAdapter(RecordActivity.this, data);
        detail.setAdapter(detailAdapter);
    }
}
