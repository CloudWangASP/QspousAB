package com.xc.qspousab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xc.qspousab.R;

import java.util.ArrayList;

/**
 * Created by cloud_wang on 17/9/19.
 */

public class DetailAdapter extends BaseAdapter {

    private TextView income_output;
    private TextView pay_output;
    private TextView income_remark;
    private TextView pay_remark;
    private TextView circular_shape;
    private Context context;

    LayoutInflater layoutInflater;
    ArrayList<Double> mData = new ArrayList();

    public DetailAdapter(Context context, ArrayList<Double> data) {
        layoutInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
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

        income_output = (TextView) convertView.findViewById(R.id.income_output);
        pay_output = (TextView) convertView.findViewById(R.id.pay_output);
        income_remark = (TextView) convertView.findViewById(R.id.income_remark);
        pay_remark = (TextView) convertView.findViewById(R.id.pay_remark);
        circular_shape = (TextView) convertView.findViewById(R.id.circular_shape);

        if (mData.get(position) > 0) {
            income_output.setText("+" + mData.get(position));
            circular_shape.setText("+");
//            circular_shape_layout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.circular_shape_deep_sky_blue2));
            income_remark.setVisibility(View.VISIBLE);
            pay_output.setVisibility(View.INVISIBLE);
            pay_remark.setVisibility(View.INVISIBLE);

        } else {
            pay_output.setText("" + mData.get(position));
            circular_shape.setText("-");
//            circular_shape_layout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.circular_shape_hot_pink));
            pay_remark.setVisibility(View.VISIBLE);
            income_output.setVisibility(View.INVISIBLE);
            income_remark.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }
}
