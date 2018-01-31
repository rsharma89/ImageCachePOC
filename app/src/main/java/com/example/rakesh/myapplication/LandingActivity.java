package com.example.rakesh.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rakesh.myapplication.adapter.ProductListAdapter;
import com.example.rakesh.myapplication.ui.LandingFragment;

import java.util.ArrayList;

public class LandingActivity extends AppCompatActivity implements CounterListner{

    private RecyclerView mRecycleView;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private ProductListAdapter productListAdapter;
    private Context context;
    private ArrayList<ImageView> mList;
    private TextView mBadgeCounterView;
    private RelativeLayout mBadgeLayout;
    private LandingFragment mLandingFragment;
    private int mItemsInCart;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mLandingFragment = new LandingFragment();
        getFragmentManager().beginTransaction().replace(R.id.container,mLandingFragment).commit();
//        initUI();
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    public void showToolbar(){

        if (toolbar != null) {
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().show();
        }
    }

    /**
     * get the Default toolbar instance
     *
     * @return default instance of the toolbar (Action bar)
     */
    protected Toolbar getToolBar() {
        return this.toolbar;
    }


    public void hideToolbar(){
        if(toolbar!=null){
            getSupportActionBar().hide();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        mBadgeLayout = (RelativeLayout) menu.findItem(R.id.menu_cart).getActionView();
        mBadgeLayout.setClickable(true);
        mBadgeCounterView = (TextView) mBadgeLayout.findViewById(R.id.counter);
        // Handle visibility of cart counter view.
        updateBadgeCount(mItemsInCart);
        return true;
    }

    /**
     * Reset count on cart menu. This method should be call after any changes done into cart list.
     * @param changedCount - Count to be set at cart.
     */
    public void setCartItemCounter(int changedCount) {
        mItemsInCart = changedCount;
        supportInvalidateOptionsMenu();
    }

    /**
     * Get count of cart item.
     * @return - Count of cart items.
     */
    public int getCartItemCounter() {
        return mItemsInCart;
    }


    public void updateBadgeCount(int count) {
        mItemsInCart = count;
        // Handle visibility of cart counter view.
        if (mItemsInCart <= 0) {
            mBadgeCounterView.setVisibility(View.GONE);
        } else {
            mBadgeCounterView.setVisibility(View.VISIBLE);
            mBadgeCounterView.setText("" + mItemsInCart);
        }
    }

    @Override
    public void updateCounter(int value) {
        updateBadgeCount(value);
    }
//
    }

