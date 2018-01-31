package com.example.rakesh.myapplication.adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.rakesh.myapplication.R;
import com.example.rakesh.myapplication.helper.Util;
import com.example.rakesh.myapplication.model.ItemAttribute;
import com.example.rakesh.myapplication.model.ProductAttribute;
import com.example.rakesh.myapplication.network.VolleyNetworkRequest;
import com.example.rakesh.myapplication.ui.ProductDetailFragment;

import java.util.ArrayList;

/**
 * Created by rakesh on 28/01/18.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<ProductAttribute> mList;
    private static final String BASE_URL = "http://static-data.surge.sh";
    String finalUrl;
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
        finalUrl = BASE_URL+imgUrl;
        holder.mItemImage.setDefaultImageResId(R.drawable.loading_img);
        holder.mItemImage.setImageUrl(finalUrl, VolleyNetworkRequest.getInstance(mContext).getImageLoader());
        holder.txtDescription.setText(mList.get(position).getProductDescription());
        holder.txtFinalPrice.setText("$"+mList.get(position).getSkuFinalPrice());
        holder.txtLastPrice.setText("$"+mList.get(position).getSkuLastPrice());
        if(mList.get(position).getProductTag()!=null) {
            holder.txtTag.setText(mList.get(position).getProductTag());
        }else{
            holder.txtTag.setVisibility(View.INVISIBLE);
        }
        holder.txtLastPrice.setPaintFlags(holder.txtLastPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public NetworkImageView mItemImage;
        public TextView txtTag,txtDescription,txtLastPrice,txtFinalPrice;
        public ViewHolder(final View itemView) {
            super(itemView);
            mItemImage = (NetworkImageView)itemView.findViewById(R.id.product_image);
            txtTag = (TextView)itemView.findViewById(R.id.product_tag);
            txtDescription = (TextView)itemView.findViewById(R.id.prod_description);
            txtFinalPrice = (TextView)itemView.findViewById(R.id.final_price);
            txtLastPrice = (TextView)itemView.findViewById(R.id.last_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString(Util.PROD_DESC,txtDescription.getText().toString());
                    bundle.putString(Util.PROD_AMOUNT,txtFinalPrice.getText().toString());
                    bundle.putString(Util.PROD_IMAGE,finalUrl);
                    FragmentManager manager = ((Activity) mContext).getFragmentManager();
                    ProductDetailFragment detailFragment = new ProductDetailFragment();
                    detailFragment.setArguments(bundle);
                    manager.beginTransaction().addToBackStack("FeaturedItemFragment.class").replace(R.id.container,detailFragment).commit();

                }
            });
        }
    }
}
