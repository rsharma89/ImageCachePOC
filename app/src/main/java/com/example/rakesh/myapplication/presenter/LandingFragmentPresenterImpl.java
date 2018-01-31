package com.example.rakesh.myapplication.presenter;

import com.example.rakesh.myapplication.CallBackListener;
import com.example.rakesh.myapplication.Interactor;
import com.example.rakesh.myapplication.helper.Util;
import com.example.rakesh.myapplication.model.Country;
import com.example.rakesh.myapplication.ui.LandingFragmentListener;

import java.util.ArrayList;

/**
 * Created by rakesh on 29/01/18.
 */

public class LandingFragmentPresenterImpl implements LandingFragmentPresenter {

    private LandingFragmentListener fragmentListener;
    private Interactor mInteractor;

    public LandingFragmentPresenterImpl(LandingFragmentListener listener,Interactor interactor){
        this.fragmentListener = listener;
        this.mInteractor = interactor;
    }

    public void mapCountryListToSpiner(){
        mInteractor.getCountryList(new CallBackListener() {
            @Override
            public void onSuccess(Object data) {
                fragmentListener.mapCountryData((ArrayList<Country>)data);
            }

            @Override
            public void onFailure() {
                fragmentListener.mapCountryData((Util.getDummyList()));
            }
        });

    }

    @Override
    public void updateCoutrySpinner() {

    }

    public void onApplyBtnClicked(){
        fragmentListener.onBtnClick();
    }
}
