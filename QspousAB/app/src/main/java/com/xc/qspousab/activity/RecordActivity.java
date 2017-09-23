package com.xc.qspousab.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.xc.qspousab.R;
import com.xc.qspousab.adapter.DetailAdapter;
import com.xc.qspousab.tools.QspousTools;

import java.util.ArrayList;


public class RecordActivity extends AppCompatActivity {
    ListView detail;

    TextView paySum;

    TextView incomeSum;

    DetailAdapter detailAdapter;

    ArrayList<Double> data = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recode);
        paySum = (TextView) findViewById(R.id.pay_sum);
        incomeSum = (TextView) findViewById(R.id.income_sum);
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

        Double plusSum = 0.0d;
        Double minusSum = 0.0d;

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) > 0) {
                //做加法
                plusSum = QspousTools.add(plusSum, data.get(i));

            } else {
                //做减法
                minusSum = QspousTools.add(minusSum, data.get(i));
            }
        }
        incomeSum.setText("+" + plusSum);
        paySum.setText(minusSum + "");

        detailAdapter = new DetailAdapter(RecordActivity.this, data);
        detail.setAdapter(detailAdapter);
    }
}
