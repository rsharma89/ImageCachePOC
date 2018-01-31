package com.example.rakesh.myapplication.ui;

import com.example.rakesh.myapplication.model.Country;

import java.util.ArrayList;

/**
 * Created by rakesh on 29/01/18.
 */

public interface LandingFragmentListener {
    void showSpinner();
    void hideSpinner();
    void mapCountryData(ArrayList<Country> list);
    void onBtnClick();

}
