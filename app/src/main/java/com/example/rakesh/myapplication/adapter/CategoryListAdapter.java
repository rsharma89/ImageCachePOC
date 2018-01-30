package com.example.rakesh.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rakesh.myapplication.model.Category;

import java.util.ArrayList;

/**
 * Created by rakesh on 29/01/18.
 */

public class CategoryListAdapter extends BaseAdapter {

    private ArrayList<Category> mList;
    private Context mContext;

    public CategoryListAdapter(Context context,ArrayList<Category> list) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_spinner_dropdown_item,viewGroup,false);
        }
        TextView textView = (TextView)view.findViewById(android.R.id.text1);
        textView.setText(mList.get(i).getContents().toString());
        return view;
    }
}
