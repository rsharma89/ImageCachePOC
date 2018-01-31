package com.example.rakesh.myapplication.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by rakesh on 28/01/18.
 */

public class Util {

    private static Context mContext;
    private static AlertDialog.Builder mProgress;
    private static AlertDialog dialog;
    private static ProgressDialog progressBar;
    public static String PROD_DESC = "PROD_DESC";
    public static String PROD_AMOUNT = "PROD_PRICE";
    public static String PROD_IMAGE = "PROD_IMAGE";

    public static String loadJSONFromAsset(Context context){//TODO
        String jsonString = null;
        try {
            InputStream is = getContext().getAssets().open("countries.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return jsonString;

    }

    public static ArrayList getDummyList(){
        ArrayList mTempCountryList = new ArrayList<>();
        mTempCountryList.add("India");
        mTempCountryList.add("Unites States");
        mTempCountryList.add("Australia");
        return mTempCountryList;
    }

    public static void setContext(Context context){
        mContext = context;
    }

    public static Context getContext(){
        return mContext;
    }

    public static void showDialog(){

        if(getContext()!=null){
            progressBar = new ProgressDialog(getContext());
            progressBar.setMessage("Please wait...");
            progressBar.setTitle("Content is loading");
            progressBar.setCancelable(false);
            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressBar.show();
        }
    }

    public static void hideDialog(){
        if(progressBar!=null) {
            progressBar.dismiss();
        }
    }

//    public static ArrayList getCountryList(){
//
//    }


}
