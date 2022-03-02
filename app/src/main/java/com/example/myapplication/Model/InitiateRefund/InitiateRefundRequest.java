package com.example.myapplication.Model.InitiateRefund;

import lombok.Data;

@Data
public class InitiateRefundRequest {
    public String merchantTransactionID;
    public String checkoutRequestID;
    public String refundType;
    public double refundAmount;
    public String currencyCode;
    public String narration;
    public String extraDetails;

    public InitiateRefundRequest(String merchantTransactionID, String checkoutRequestID, String refundType, double refundAmount, String currencyCode, String narration, String extraDetails) {
        this.merchantTransactionID = merchantTransactionID;
        this.checkoutRequestID = checkoutRequestID;
        this.refundType = refundType;
        this.refundAmount = refundAmount;
        this.currencyCode = currencyCode;
        this.narration = narration;
        this.extraDetails = extraDetails;
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

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }
}
