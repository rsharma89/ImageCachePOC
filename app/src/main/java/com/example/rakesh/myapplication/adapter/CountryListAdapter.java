package com.example.rakesh.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rakesh.myapplication.model.Country;

import java.util.ArrayList;

/**
 * Created by rakesh on 29/01/18.
 */

public class CountryListAdapter extends BaseAdapter {

    private ArrayList<Country> countryList;
    private Context mContext;

    public CountryListAdapter(Context mContext, ArrayList list) {
        this.mContext = mContext;
        countryList = list;
    }


    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int i) {
        return countryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean isEnabled(int position) {
        if(position==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_spinner_dropdown_item,viewGroup,false);
        }
        TextView textView = (TextView)view.findViewById(android.R.id.text1);
        textView.setTextColor(Color.BLACK);
        textView.setText(countryList.get(i).getName());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }
}
