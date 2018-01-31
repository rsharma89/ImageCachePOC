package com.example.rakesh.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rakesh on 29/01/18.
 */

public class PagingActionTemplate {


    @SerializedName("label")
    @Expose
    private Object label;
    @SerializedName("navigationState")
    @Expose
    private String navigationState;

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public String getNavigationState() {
        return navigationState;
    }

    public void setNavigationState(String navigationState) {
        this.navigationState = navigationState;
    }

}
