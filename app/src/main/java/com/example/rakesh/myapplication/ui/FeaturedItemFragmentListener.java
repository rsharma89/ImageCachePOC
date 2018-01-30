package com.example.rakesh.myapplication.ui;

import com.example.rakesh.myapplication.model.Category;

import java.util.ArrayList;

/**
 * Created by rakesh on 29/01/18.
 */

public interface FeaturedItemFragmentListener {

    void loadCategoryData(ArrayList<Category> list);
    void showProgressDialog();
    void hideProgressBar();
    void loadProductData();
}
