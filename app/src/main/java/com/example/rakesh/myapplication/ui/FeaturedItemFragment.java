package com.example.rakesh.myapplication.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;

import com.example.rakesh.myapplication.InteractorImpl;
import com.example.rakesh.myapplication.R;
import com.example.rakesh.myapplication.adapter.CategoryListAdapter;
import com.example.rakesh.myapplication.adapter.ProductListAdapter;
import com.example.rakesh.myapplication.helper.Util;
import com.example.rakesh.myapplication.model.Content;
import com.example.rakesh.myapplication.model.ProductAttribute;
import com.example.rakesh.myapplication.presenter.FeaturedItemFragmentPresenterImpl;
import com.example.rakesh.myapplication.presenter.FeaturedItemPresenter;

import java.util.ArrayList;

/**
 * Created by rakesh on 29/01/18.
 */

public class FeaturedItemFragment extends Fragment implements FeaturedItemFragmentListener, AdapterView.OnItemSelectedListener{

    private Spinner categorySpinner;
    private FeaturedItemPresenter featuredItemPresenter;
    private Context mContext;
    private RecyclerView recyclerView;
    private ArrayList<Content> categoryList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.featured_item,container,false);
        featuredItemPresenter = new FeaturedItemFragmentPresenterImpl(this,new InteractorImpl());
        featuredItemPresenter.fetchCategoryList();
        featuredItemPresenter.fetchProductData("");
        initUI(view);
        return view;
    }

    private void initUI(View v) {
        categorySpinner = (Spinner) v.findViewById(R.id.category_list);
        recyclerView = (RecyclerView)v.findViewById(R.id.featured_item_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext,2);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void loadCategoryData(ArrayList<Content> list) {
        categoryList = list;
        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(mContext,categoryList);
        categorySpinner.setAdapter(categoryListAdapter);
        categorySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void showProgressDialog() {
        Util.showDialog();
    }

    @Override
    public void hideProgressBar() {
        Util.hideDialog();
    }

    @Override
    public void loadProductData(ArrayList<ProductAttribute> productList) {
        ProductListAdapter productListAdapter = new ProductListAdapter(mContext,productList);
        recyclerView.setAdapter(productListAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String contentId = Integer.toString(categoryList.get(i).getId());
        featuredItemPresenter.fetchProductData(contentId);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
