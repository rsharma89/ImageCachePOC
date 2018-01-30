package com.example.rakesh.myapplication.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rakesh on 29/01/18.
 */


public class ItemAttribute {

    @SerializedName("Brand")
    @Expose
    private String brand;
    @SerializedName("sku.unit_of_measure")
    @Expose
    private String skuUnitOfMeasure;
    @SerializedName("records")
    @Expose
    private List<ProductAttribute> records = null;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSkuUnitOfMeasure() {
        return skuUnitOfMeasure;
    }

    public void setSkuUnitOfMeasure(String skuUnitOfMeasure) {
        this.skuUnitOfMeasure = skuUnitOfMeasure;
    }

    public List<ProductAttribute> getRecords() {
        return records;
    }

    public void setRecords(List<ProductAttribute> records) {
        this.records = records;
    }

}