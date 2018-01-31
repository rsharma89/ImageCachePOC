package com.example.rakesh.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rakesh on 29/01/18.
 */

public class Record {


    @SerializedName("numRecords")
    @Expose
    private Integer numRecords;
    @SerializedName("attributes")
    @Expose
    private ItemAttribute attributes;

    public Integer getNumRecords() {
        return numRecords;
    }

    public void setNumRecords(Integer numRecords) {
        this.numRecords = numRecords;
    }

    public ItemAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(ItemAttribute attributes) {
        this.attributes = attributes;
    }

}
