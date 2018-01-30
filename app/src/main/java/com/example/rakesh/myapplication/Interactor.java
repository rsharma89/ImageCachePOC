package com.example.rakesh.myapplication;

import android.content.Context;

/**
 * Created by rakesh on 29/01/18.
 */

public interface Interactor {

    public void getCountryList(CallBackListener listener);
    public void getCategoryList(CallBackListener listener);
    public void populateCategoryData(CallBackListener listener, String categoryId);
}
