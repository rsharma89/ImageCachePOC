package com.example.rakesh.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.rakesh.myapplication.adapter.ProductListAdapter;
import com.example.rakesh.myapplication.ui.LandingFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private ProductListAdapter productListAdapter;
    private Context context;
    private ArrayList<ImageView> mList;
    private LandingFragment mLandingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void hideActionBar(){

    }
//
//    private void initUI() {
//    context = getApplicationContext();
//    mList = new ArrayList(100);
//    mRecycleView = (RecyclerView) findViewById(R.id.recyclerView);
//    recyclerViewLayoutManager = new GridLayoutManager(context,2);
//    productListAdapter = new ProductListAdapter(context,mList);
//    mRecycleView.setLayoutManager(recyclerViewLayoutManager);
//    mRecycleView.setAdapter(productListAdapter);
    }

