package com.example.rakesh.myapplication.presenter;

import com.example.rakesh.myapplication.CallBackListener;
import com.example.rakesh.myapplication.InteractorImpl;
import com.example.rakesh.myapplication.helper.Util;
import com.example.rakesh.myapplication.model.Category;
import com.example.rakesh.myapplication.model.Content;
import com.example.rakesh.myapplication.model.ProductAttribute;
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
    public void fetchProductData(String categoryId) {
//        mListener.showProgressDialog();
        mInteractor.getCategoryData(new CallBackListener() {
            @Override
            public void onSuccess(Object data) {
                mListener.loadProductData((ArrayList<ProductAttribute>)data);
//                Util.hideDialog();
            }

            @Override
            public void onFailure() {

            }
        },categoryId);

    }

    @Override
    public void fetchCategoryList() {
//        mListener.showProgressDialog();
        mInteractor.getCategoryList(new CallBackListener() {
            @Override
            public void onSuccess(Object data) {
                mListener.loadCategoryData((ArrayList<Content>) data);
//                Util.hideDialog();
//                mListener.hideProgressBar();
            }

            @Override
            public void onFailure() {
                mListener.hideProgressBar();
            }
        });
    }

}
