package com.example.rakesh.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rakesh on 29/01/18.
 */

public class ProductAttribute {

    @SerializedName("product.id")
    @Expose
    private String productId;
    @SerializedName("product.category.id")
    @Expose
    private String productCategoryId;
    @SerializedName("product.image.url")
    @Expose
    private String productImageUrl;
    @SerializedName("sku.displayName")
    @Expose
    private String skuDisplayName;
    @SerializedName("product.displayName")
    @Expose
    private String productDisplayName;
    @SerializedName("product.description")
    @Expose
    private String productDescription;
    @SerializedName("product.tag")
    @Expose
    private String productTag;
    @SerializedName("sku.finalPrice")
    @Expose
    private String skuFinalPrice;
    @SerializedName("sku.lastPrice")
    @Expose
    private String skuLastPrice;
    @SerializedName("maxQuantity")
    @Expose
    private String maxQuantity;
    @SerializedName("inventoryTotal")
    @Expose
    private String inventoryTotal;
    @SerializedName("inventoryUsed")
    @Expose
    private String inventoryUsed;
    @SerializedName("priceStrikeOff")
    @Expose
    private String priceStrikeOff;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getSkuDisplayName() {
        return skuDisplayName;
    }

    public void setSkuDisplayName(String skuDisplayName) {
        this.skuDisplayName = skuDisplayName;
    }

    public String getProductDisplayName() {
        return productDisplayName;
    }

    public void setProductDisplayName(String productDisplayName) {
        this.productDisplayName = productDisplayName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductTag() {
        return productTag;
    }

    public void setProductTag(String productTag) {
        this.productTag = productTag;
    }

    public String getSkuFinalPrice() {
        return skuFinalPrice;
    }

    public void setSkuFinalPrice(String skuFinalPrice) {
        this.skuFinalPrice = skuFinalPrice;
    }

    public String getSkuLastPrice() {
        return skuLastPrice;
    }

    public void setSkuLastPrice(String skuLastPrice) {
        this.skuLastPrice = skuLastPrice;
    }

    public String getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(String maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public String getInventoryTotal() {
        return inventoryTotal;
    }

    public void setInventoryTotal(String inventoryTotal) {
        this.inventoryTotal = inventoryTotal;
    }

    public String getInventoryUsed() {
        return inventoryUsed;
    }

    public void setInventoryUsed(String inventoryUsed) {
        this.inventoryUsed = inventoryUsed;
    }

    public String getPriceStrikeOff() {
        return priceStrikeOff;
    }

    public void setPriceStrikeOff(String priceStrikeOff) {
        this.priceStrikeOff = priceStrikeOff;
    }
}
