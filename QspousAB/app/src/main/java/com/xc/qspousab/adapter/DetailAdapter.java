package com.xc.qspousab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xc.qspousab.R;

/**
 * Created by cloud_wang on 17/9/19.
 */

public class DetailAdapter extends BaseAdapter {

    private TextView incomeOutput;
    private TextView payOutput;
    private View rightLine;
    private View leftLine;
    LayoutInflater layoutInflater;

    public DetailAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.adapter_detail_view, null);
        incomeOutput = (TextView) convertView.findViewById(R.id.incomeOutput);
        payOutput = (TextView) convertView.findViewById(R.id.payOutput);
        rightLine = convertView.findViewById(R.id.rightLine);
        leftLine = convertView.findViewById(R.id.leftLine);
        incomeOutput.setText("+450");
        payOutput.setText("-130");

        /**
         * 模拟真实数据
         **/
        if (position % 3 == 0) {
            incomeOutput.setVisibility(View.INVISIBLE);
            leftLine.setVisibility(View.INVISIBLE);
        } else {
            payOutput.setVisibility(View.INVISIBLE);
            rightLine.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }
}
