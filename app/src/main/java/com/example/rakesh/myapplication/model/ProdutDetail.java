package com.example.rakesh.myapplication.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rakesh on 29/01/18.
 */

public class ProdutDetail {

    @SerializedName("recsPerPage")
    @Expose
    private Integer recsPerPage;
    @SerializedName("totalNumRecs")
    @Expose
    private Integer totalNumRecs;
    @SerializedName("firstRecNum")
    @Expose
    private Integer firstRecNum;
    @SerializedName("lastRecNum")
    @Expose
    private Integer lastRecNum;
    @SerializedName("pagingActionTemplate")
    @Expose
    private PagingActionTemplate pagingActionTemplate;
    @SerializedName("sortOptions")
    @Expose
    private List<SortOption> sortOptions = null;
    @SerializedName("records")
    @Expose
    private List<Record> records = null;

    public Integer getRecsPerPage() {
        return recsPerPage;
    }

    public void setRecsPerPage(Integer recsPerPage) {
        this.recsPerPage = recsPerPage;
    }

    public Integer getTotalNumRecs() {
        return totalNumRecs;
    }

    public void setTotalNumRecs(Integer totalNumRecs) {
        this.totalNumRecs = totalNumRecs;
    }

    public Integer getFirstRecNum() {
        return firstRecNum;
    }

    public void setFirstRecNum(Integer firstRecNum) {
        this.firstRecNum = firstRecNum;
    }

    public Integer getLastRecNum() {
        return lastRecNum;
    }

    public void setLastRecNum(Integer lastRecNum) {
        this.lastRecNum = lastRecNum;
    }

    public PagingActionTemplate getPagingActionTemplate() {
        return pagingActionTemplate;
    }

    public void setPagingActionTemplate(PagingActionTemplate pagingActionTemplate) {
        this.pagingActionTemplate = pagingActionTemplate;
    }

    public List<SortOption> getSortOptions() {
        return sortOptions;
    }

    public void setSortOptions(List<SortOption> sortOptions) {
        this.sortOptions = sortOptions;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

}
