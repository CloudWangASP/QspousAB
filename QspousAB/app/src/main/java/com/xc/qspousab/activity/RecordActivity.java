package com.xc.qspousab.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.xc.qspousab.R;
import com.xc.qspousab.adapter.DetailAdapter;
import com.xc.qspousab.tools.QspousTools;

import java.util.ArrayList;


public class RecordActivity extends AppCompatActivity {
    ListView detail;

    TextView paySum;

    TextView incomeSum;

    TextView remainderMoney;

    DetailAdapter detailAdapter;

    ArrayList<Double> data = new ArrayList();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recode);
        paySum = (TextView) findViewById(R.id.pay_sum);
        incomeSum = (TextView) findViewById(R.id.income_sum);
        remainderMoney = (TextView) findViewById(R.id.remainder_money);
        detail = (ListView) findViewById(R.id.detail);

        //模拟数据
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

        detailAdapter = new DetailAdapter(RecordActivity.this, data);
        detail.setAdapter(detailAdapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Record Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
