
package com.example.myapplication.Model.QueryRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payment {

    @SerializedName("payerTransactionID")
    @Expose
    public String payerTransactionID;
    @SerializedName("MSISDN")
    @Expose
    public Long msisdn;
    @SerializedName("accountNumber")
    @Expose
    public String accountNumber;
    @SerializedName("customerName")
    @Expose
    public String customerName;
    @SerializedName("amountPaid")
    @Expose
    public Integer amountPaid;
    @SerializedName("payerClientCode")
    @Expose
    public String payerClientCode;
    @SerializedName("cpgTransactionID")
    @Expose
    public String cpgTransactionID;
    @SerializedName("paymentDate")
    @Expose
    public String paymentDate;
    @SerializedName("clientName")
    @Expose
    public String clientName;
    @SerializedName("clientDisplayName")
    @Expose
    public String clientDisplayName;
    @SerializedName("currencyCode")
    @Expose
    public String currencyCode;
    @SerializedName("currencyID")
    @Expose
    public Integer currencyID;
    @SerializedName("paymentID")
    @Expose
    public Integer paymentID;
    @SerializedName("hubOverallStatus")
    @Expose
    public Integer hubOverallStatus;
    @SerializedName("clientCategoryID")
    @Expose
    public Integer clientCategoryID;
    @SerializedName("clientCategoryName")
    @Expose
    public String clientCategoryName;
    @SerializedName("payerNarration")
    @Expose
    public Object payerNarration;

}
