package com.example.rakesh.myapplication.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.rakesh.myapplication.InteractorImpl;
import com.example.rakesh.myapplication.R;
import com.example.rakesh.myapplication.adapter.CountryListAdapter;
import com.example.rakesh.myapplication.helper.Util;
import com.example.rakesh.myapplication.model.Country;
import com.example.rakesh.myapplication.presenter.LandingFragmentPresenter;
import com.example.rakesh.myapplication.presenter.LandingFragmentPresenterImpl;
import com.example.rakesh.myapplication.service.BabyPinkServiceClass;

import java.util.ArrayList;

/**
 * Created by rakesh on 28/01/18.
 */

public class LandingFragment extends Fragment implements View.OnClickListener,LandingFragmentListener,AdapterView.OnItemSelectedListener {

    private Spinner countrySpinner,stateSpinner;
    private Button applyBtn;
    private Context mContext;
    private ArrayList<Country> mList;
    private LandingFragmentPresenter presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.landing_page,container,false);
        presenter = new LandingFragmentPresenterImpl(this,new InteractorImpl());
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        Util.setContext(mContext);
        countrySpinner = (Spinner)view.findViewById(R.id.country_list);
        stateSpinner = (Spinner)view.findViewById(R.id.state_list);
        stateSpinner.setEnabled(false);
        presenter.mapCountryListToSpiner();
        applyBtn = (Button)view.findViewById(R.id.applyButton);
        applyBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.applyButton :
                presenter.onApplyBtnClicked();
                break;
            default:
                break;
        }
    }

    @Override
    public void showSpinner() {

    }

    @Override
    public void hideSpinner() {

    }

    @Override
    public void mapCountryData(ArrayList list) {
        mList = list;
        CountryListAdapter arrayAdapter = new CountryListAdapter(mContext,mList);
        countrySpinner.setAdapter(arrayAdapter);
        countrySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onBtnClick() {
        FeaturedItemFragment featuredItemFragment = new FeaturedItemFragment();
        getFragmentManager().beginTransaction().addToBackStack("LandingFragment.class").replace(R.id.container,featuredItemFragment).commit();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int id = adapterView.getId();
        switch (id){
            case R.id.country_list:
                stateSpinner.setEnabled(true);
                ArrayAdapter arrayAdapter = new ArrayAdapter(mContext,android.R.layout.simple_spinner_dropdown_item,
                        android.R.id.text1,mList.get(i).getStates());
                stateSpinner.setAdapter(arrayAdapter);
                break;
            case R.id.state_list:

                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
