package com.example.rakesh.myapplication.presenter;

import android.app.AlertDialog;
import android.content.Context;

import com.example.rakesh.myapplication.CallBackListener;
import com.example.rakesh.myapplication.InteractorImpl;
import com.example.rakesh.myapplication.model.Category;
import com.example.rakesh.myapplication.ui.FeaturedItemFragment;
import com.example.rakesh.myapplication.ui.FeaturedItemFragmentListener;

import java.util.ArrayList;

/**
 * Created by rakesh on 29/01/18.
 */

public class FeaturedItemFragmentPresenterImpl implements FeaturedItemPresenter {

    private FeaturedItemFragmentListener mListener;
    private InteractorImpl mInteractor;

    public FeaturedItemFragmentPresenterImpl(FeaturedItemFragmentListener featuredItemFragment, InteractorImpl interactor) {
        this.mListener = featuredItemFragment;
        this.mInteractor = interactor;
    }


    @Override
    public void fetchFeaturedList(String categoryId) {
        mListener.showProgressDialog();
        mInteractor.populateCategoryData(new CallBackListener() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onFailure() {

            }
        },categoryId);

    }

    @Override
    public void fetchCategoryList() {
        mListener.showProgressDialog();
        mInteractor.getCategoryList(new CallBackListener() {
            @Override
            public void onSuccess(Object data) {
                mListener.hideProgressBar();
                mListener.loadCategoryData((ArrayList<Category>)data);
            }

            @Override
            public void onFailure() {
                mListener.hideProgressBar();
            }
        });
    }

}
