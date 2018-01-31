package com.example.rakesh.myapplication.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rakesh.myapplication.CounterListner;
import com.example.rakesh.myapplication.R;
import com.example.rakesh.myapplication.adapter.ViewPagerAdapter;
import com.example.rakesh.myapplication.helper.Util;


/**
 * Created by rakesh on 31/01/18.
 */

public class ProductDetailFragment extends Fragment implements ViewPager.OnPageChangeListener,View.OnClickListener,CounterListner{

    private Context mContext;
    private PagerTabStrip mTitleStrip;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private ViewPagerAdapter mAdapter;
    private ViewPager pager_images;
    String mProductDesc,mProductPrice,mProdUrl;
    private TextView mDescText,mPriceText;
    private ImageView mIncrement,mDecrement;
    private Button mCounter,mAddProd;
    private int mCount=1;
    private CounterListner counterListner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        try {
            counterListner = (CounterListner) mContext;
            counterListner.updateCounter(mCount);
        } catch (ClassCastException e) {
            throw new ClassCastException(mContext.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_detail_view,container,false);
        Bundle b = getArguments();
        if(b!=null){
            mProductDesc = b.getString(Util.PROD_DESC);
            mProductPrice = b.getString(Util.PROD_AMOUNT);
            mProdUrl = b.getString(Util.PROD_IMAGE);
        }
        initUI(view);
        return view;
    }

    private void initUI(View v) {
        mTitleStrip = (PagerTabStrip)v.findViewById(R.id.pager_title_strip);
        pager_images = (ViewPager)v.findViewById(R.id.pager);
        pager_indicator = (LinearLayout) v.findViewById(R.id.pager_dots);
        mAdapter = new ViewPagerAdapter(mContext,mProdUrl);
        mIncrement = (ImageView)v.findViewById(R.id.increment_producr);
        mDecrement = (ImageView)v.findViewById(R.id.decrement_product);
        mCounter = (Button)v.findViewById(R.id.product_count);
        mAddProd = (Button)v.findViewById(R.id.addProduct);
        mDescText = (TextView)v.findViewById(R.id.prod_detail_desc);
        mDescText.setText(mProductDesc);
        mPriceText = (TextView)v.findViewById(R.id.product_amount);
        mPriceText.setText(mProductPrice);
        pager_images.setAdapter(mAdapter);
        pager_images.setCurrentItem(0);
        pager_images.setOnPageChangeListener(this);
        setUiPageViewController();
        mIncrement.setOnClickListener(this);
        mDecrement.setOnClickListener(this);
        mAddProd.setOnClickListener(this);
        mCounter.setOnClickListener(this);
    }

    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(mContext);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditems_dots));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditems_dots));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditems_dots));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditems_dots));

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.increment_producr:
                mCount++;
                if(counterListner!=null) {
                    counterListner.updateCounter(mCount);
                    mCounter.setText(""+mCount);
                }
                break;
            case R.id.decrement_product:
                if(mCount>1) {
                    mCount--;
                }
                if(counterListner!=null && mCount>0) {
                    counterListner.updateCounter(mCount);
                    mCounter.setText(""+mCount);
                }
                break;
            case R.id.addProduct:
                if(counterListner!=null) {
                    counterListner.updateCounter(mCount);
                }
                break;
            default:
                break;

        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        counterListner=null;
    }

    @Override
    public void updateCounter(int value) {
        mCounter.setText(""+value);
    }
}
