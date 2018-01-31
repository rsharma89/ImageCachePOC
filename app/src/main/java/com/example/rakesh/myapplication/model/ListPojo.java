package com.example.rakesh.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by rakesh on 29/01/18.
 */

public class ListPojo implements Serializable {

    @SerializedName("country")
    @Expose
    private ArrayList<Country> country = null;

    public ArrayList<Country> getCountry() {
        return country;
    }

    public void setCountry(ArrayList<Country> country) {
        this.country = country;
    }

}
