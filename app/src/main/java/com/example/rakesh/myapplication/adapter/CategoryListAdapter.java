package com.example.rakesh.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rakesh.myapplication.R;
import com.example.rakesh.myapplication.model.Category;
import com.example.rakesh.myapplication.model.Content;
import com.example.rakesh.myapplication.ui.ProductDetailFragment;

import java.util.ArrayList;

/**
 * Created by rakesh on 29/01/18.
 */

public class CategoryListAdapter extends BaseAdapter {

    private ArrayList<Content> mList;
    private Context mContext;
    private TextView textView;

    public CategoryListAdapter(Context context,ArrayList<Content> list) {
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
    public boolean isEnabled(int position) {
        if(mList.get(position).getActive()){
            textView.setTextColor(Color.BLACK);
            return true;
        }else{
            textView.setTextColor(Color.GRAY);
            return false;
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_spinner_dropdown_item,viewGroup,false);
        }
        textView = (TextView)view.findViewById(android.R.id.text1);
        textView.setText(mList.get(i).getDisplayName());

        return view;
    }
}
