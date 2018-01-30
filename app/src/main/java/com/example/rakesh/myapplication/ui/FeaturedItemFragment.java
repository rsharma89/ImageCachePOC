package com.example.rakesh.myapplication.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.example.rakesh.myapplication.InteractorImpl;
import com.example.rakesh.myapplication.R;
import com.example.rakesh.myapplication.adapter.CategoryListAdapter;
import com.example.rakesh.myapplication.model.Category;
import com.example.rakesh.myapplication.presenter.FeaturedItemFragmentPresenterImpl;
import com.example.rakesh.myapplication.presenter.FeaturedItemPresenter;

import java.util.ArrayList;

/**
 * Created by rakesh on 29/01/18.
 */

public class FeaturedItemFragment extends Fragment implements FeaturedItemFragmentListener{

    private Spinner categorySpinner;
    private FeaturedItemPresenter featuredItemPresenter;
    private Context mContext;
    private AlertDialog.Builder mProgress;
    private AlertDialog dialog;

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
        featuredItemPresenter.fetchFeaturedList("101");
        initUI(view);
        return view;
    }

    private void initUI(View v) {
        categorySpinner = (Spinner) v.findViewById(R.id.category_list);
    }

    @Override
    public void loadCategoryData(ArrayList<Category> list) {
        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(mContext,list);
        categorySpinner.setAdapter(categoryListAdapter);
    }

    @Override
    public void showProgressDialog() {
        mProgress = new AlertDialog.Builder(getActivity());
        mProgress.setMessage("Content is loading")
                .setTitle("Please Wait");
        dialog = mProgress.create();
    }

    @Override
    public void hideProgressBar() {
        dialog.dismiss();
    }

    @Override
    public void loadProductData() {

    }
}
