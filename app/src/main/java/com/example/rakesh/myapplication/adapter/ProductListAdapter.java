package com.example.rakesh.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rakesh.myapplication.R;
import com.example.rakesh.myapplication.model.ProductAttribute;

import java.util.ArrayList;

/**
 * Created by rakesh on 28/01/18.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList mList;

    public ProductListAdapter(Context context, ArrayList list){
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_view_item,parent,false);
        ViewHolder viewHolder1 = new ViewHolder(view);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mItemImage;
        public TextView txtTag,txtDescription,txtLastPrice,txtFinalPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            mItemImage = (ImageView)itemView.findViewById(R.id.product_image);
            txtTag = (TextView)itemView.findViewById(R.id.product_tag);
            txtDescription = (TextView)itemView.findViewById(R.id.prod_description);
            txtFinalPrice = (TextView)itemView.findViewById(R.id.final_price);
            txtLastPrice = (TextView)itemView.findViewById(R.id.last_price);
        }
    }
}
