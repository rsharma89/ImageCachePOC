package com.example.rakesh.myapplication;

import android.content.Context;

import com.example.rakesh.myapplication.service.BabyPinkServiceClass;

/**
 * Created by rakesh on 29/01/18.
 */

public class InteractorImpl implements Interactor {

    private BabyPinkServiceClass serviceClass;

    @Override
    public void getCountryList(CallBackListener listener) {
            serviceClass = new BabyPinkServiceClass();
            serviceClass.getCountryList(listener);
    }


    @Override
    public void getCategoryList(CallBackListener listener) {
        serviceClass = new BabyPinkServiceClass();
        serviceClass.getCategoryList(listener);

    }

    @Override
    public void getCategoryData(CallBackListener listener, String categoryId) {
        serviceClass = new BabyPinkServiceClass();
        serviceClass.getCategoryData(listener,categoryId);
    }
}
