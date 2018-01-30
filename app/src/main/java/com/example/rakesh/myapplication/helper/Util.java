package com.example.rakesh.myapplication.helper;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by rakesh on 28/01/18.
 */

public class Util {

    private static Context mContext;

    public static String loadJSONFromAsset(Context context){
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

//    public static ArrayList getCountryList(){
//
//    }


}
