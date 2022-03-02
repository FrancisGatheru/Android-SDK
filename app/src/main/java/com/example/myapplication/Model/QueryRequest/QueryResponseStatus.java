package com.example.myapplication.Model.QueryRequest;

import com.example.myapplication.Model.PostCheckout.Results;
import com.example.myapplication.Model.PostCheckout.Status;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueryResponseStatus {

    @SerializedName("status")
    @Expose
    public Status status;
    @SerializedName("results")
    @Expose
    public Results results;

}
