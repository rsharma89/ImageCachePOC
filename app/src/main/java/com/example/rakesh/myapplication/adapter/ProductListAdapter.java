package com.example.rakesh.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.rakesh.myapplication.R;
import com.example.rakesh.myapplication.model.ProductAttribute;
import com.example.rakesh.myapplication.network.VolleyNetworkRequest;

import java.util.ArrayList;

/**
 * Created by rakesh on 28/01/18.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<ProductAttribute> mList;
    private static final String BASE_URL = "http://static-data.surge.sh";

    public ProductListAdapter(Context context, ArrayList<ProductAttribute> list){
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
        String prodId = mList.get(position).getProductId();
        String imgUrl = mList.get(position).getProductImageUrl().replace("{product.id}",prodId);
        String finalUrl = BASE_URL+imgUrl;
        holder.mItemImage.setImageUrl(finalUrl, VolleyNetworkRequest.getInstance(mContext).getImageLoader());
        holder.txtDescription.setText(mList.get(position).getProductDescription());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public NetworkImageView mItemImage;
        public TextView txtTag,txtDescription,txtLastPrice,txtFinalPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            mItemImage = (NetworkImageView)itemView.findViewById(R.id.product_image);
            txtTag = (TextView)itemView.findViewById(R.id.product_tag);
            txtDescription = (TextView)itemView.findViewById(R.id.prod_description);
            txtFinalPrice = (TextView)itemView.findViewById(R.id.final_price);
            txtLastPrice = (TextView)itemView.findViewById(R.id.last_price);
        }
    }
}
