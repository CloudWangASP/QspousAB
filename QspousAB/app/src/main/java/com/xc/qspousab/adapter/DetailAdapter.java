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


    LayoutInflater layoutInflater;
    ArrayList<Double> mData = new ArrayList();

    public DetailAdapter(Context context, ArrayList<Double> data) {
        layoutInflater = LayoutInflater.from(context);
        this.mData = data;
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

        return convertView;
    }
}
