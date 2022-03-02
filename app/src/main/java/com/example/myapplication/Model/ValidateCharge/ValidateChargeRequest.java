
package com.example.myapplication.Model.ValidateCharge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidateChargeRequest {

    @SerializedName("merchantTransactionID")
    @Expose
    private String merchantTransactionID;
    @SerializedName("checkoutRequestID")
    @Expose
    private String checkoutRequestID;
    @SerializedName("chargeRequestID")
    @Expose
    private Integer chargeRequestID;
    @SerializedName("validationToken")
    @Expose
    private String validationToken;

    public ValidateChargeRequest(String merchantTransactionID, String checkoutRequestID, Integer chargeRequestID, String validationToken) {
        this.merchantTransactionID = merchantTransactionID;
        this.checkoutRequestID = checkoutRequestID;
        this.chargeRequestID = chargeRequestID;
        this.validationToken = validationToken;
    }

    public String getMerchantTransactionID() {
        return merchantTransactionID;
    }

    public void setMerchantTransactionID(String merchantTransactionID) {
        this.merchantTransactionID = merchantTransactionID;
    }

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }

    public Integer getChargeRequestID() {
        return chargeRequestID;
    }

    public void setChargeRequestID(Integer chargeRequestID) {
        this.chargeRequestID = chargeRequestID;
    }

    public String getValidationToken() {
        return validationToken;
    }

    public void setValidationToken(String validationToken) {
        this.validationToken = validationToken;
    }

}
