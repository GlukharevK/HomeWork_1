package com.glukharevk.firsthomework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter{
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<StringItems> data;
    int img = R.drawable.ic_launcher;

    ListAdapter(Context context, ArrayList<StringItems> data) {
        ctx = context;
        this.data = data;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.listitem, parent, false);
        }

        if (position % 2 == 0) {
            view.setBackgroundResource(R.drawable.color1);
        } else {
            view.setBackgroundResource(R.drawable.color2);
        }

        StringItems p = getStringItems(position);

        ((TextView) view.findViewById(R.id.heading)).setText(p.name);
        ((ImageView) view.findViewById(R.id.ivImg1)).setImageResource(img);


        return view;
    }
    StringItems getStringItems(int position) {
        return ((StringItems) getItem(position));
    }



}