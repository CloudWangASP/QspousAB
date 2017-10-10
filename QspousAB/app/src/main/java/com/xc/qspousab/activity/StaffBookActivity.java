package com.xc.qspousab.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.xc.qspousab.R;
import com.xc.qspousab.adapter.DetailAdapter;
import com.xc.qspousab.tools.QspousTools;
import com.xc.qspousab.view.NiftyDialogBuilder;

import java.util.ArrayList;


public class StaffBookActivity extends AppCompatActivity {
    ListView detail;
    TextView paySum;
    TextView incomeSum;
    TextView remainderMoney;
    DetailAdapter detailAdapter;
    ArrayList<Double> data = new ArrayList();
    TextView date;
    TextView add;
    TextView back;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_book);
        paySum = (TextView) findViewById(R.id.pay_sum);
        incomeSum = (TextView) findViewById(R.id.income_sum);
        remainderMoney = (TextView) findViewById(R.id.remainder_money);
        detail = (ListView) findViewById(R.id.detail);
        date = (TextView) findViewById(R.id.date);
        add = (TextView) findViewById(R.id.add);
        back = (TextView) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enter(v);
            }
        });

        //模拟数据,option+enter可查看报红项
        data.add(80.6);
        data.add(-20.0);
        data.add(296122371.5);
        data.add(543.5);
        data.add(-510.0);
        data.add(-180.8);
        data.add(484.0);
        data.add(340.8);
        data.add(880.3);
        data.add(-124.5);

        Double plusSum = 0.0d;
        Double minusSum = 0.0d;
        Double remainderSum = 0.0d;

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) > 0) {
                //做加法
                plusSum = QspousTools.add(plusSum, data.get(i));

            } else {
                //做减法
                minusSum = QspousTools.add(minusSum, data.get(i));
            }
        }
        remainderSum = QspousTools.add(plusSum, minusSum);

        incomeSum.setText("+" + plusSum);
        paySum.setText(minusSum + "");
        remainderMoney.setText(remainderSum + "");

        detailAdapter = new DetailAdapter(StaffBookActivity.this, data);
        detail.setAdapter(detailAdapter);
    }

    private void enter(View v) {
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(StaffBookActivity.this);
        dialogBuilder
                .withTitle("添加事件")
                .hideMessage()
                .withTitleColor(getResources().getColor(R.color.colorWhite))
                .withDividerColor(getResources().getColor(R.color.colorLogoYellow))
                .withDialogColor(getResources().getColor(R.color.colorLogoYellow))
                .withIcon(getResources().getDrawable(R.drawable.dialog_icon))
                .withDuration(500)
                .withEffect(Effectstype.Newspager)
                .withButton1Text("确定")
                .withButton2Text("取消")
                .isCancelableOnTouchOutside(true)
                .setCustomView(R.layout.activity_popup, v.getContext())
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.dismiss();
                    }
                })
                .show();

    }

}
