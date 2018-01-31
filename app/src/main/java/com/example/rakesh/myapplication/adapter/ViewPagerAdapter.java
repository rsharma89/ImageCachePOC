package com.example.rakesh.myapplication.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.toolbox.NetworkImageView;
import com.example.rakesh.myapplication.R;
import com.example.rakesh.myapplication.network.VolleyNetworkRequest;

/**
 * Created by rakesh on 31/01/18.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private String prodImageUrl;

    public ViewPagerAdapter(Context mContext,String url) {
        this.mContext = mContext;
        prodImageUrl = url;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);

        NetworkImageView imageView = (NetworkImageView) itemView.findViewById(R.id.img_pager_item);
        imageView.setDefaultImageResId(R.drawable.loading_img);
        imageView.setImageUrl(prodImageUrl, VolleyNetworkRequest.getInstance(mContext).getImageLoader());
//        imageView.setImageResource(mResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }


}
