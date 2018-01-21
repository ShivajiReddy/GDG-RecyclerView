package com.example.shivaji.recyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataList{
    @Expose
    @SerializedName("data")
    private List<Data> dataList;

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}