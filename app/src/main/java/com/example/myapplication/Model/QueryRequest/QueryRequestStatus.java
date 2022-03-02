package com.example.myapplication.Model.QueryRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class QueryRequestStatus {

    @SerializedName("merchantTransactionID")
    @Expose
    public String merchantTransactionID;
    @SerializedName("serviceCode")
    @Expose
    public String serviceCode;
    @SerializedName("checkoutRequestID")
    @Expose
    public String checkoutRequestID;

    public QueryRequestStatus(String merchantTransactionID, String serviceCode, String checkoutRequestID) {
        this.merchantTransactionID = merchantTransactionID;
        this.serviceCode = serviceCode;
        this.checkoutRequestID = checkoutRequestID;
    }
}
