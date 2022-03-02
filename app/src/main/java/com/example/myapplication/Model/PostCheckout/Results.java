package com.example.myapplication.Model.PostCheckout;

import java.util.List;

import lombok.Data;

@Data
public class Results {

    public Integer checkoutRequestID;
    public String merchantTransactionID;
    public Double conversionRate;
    public String originalCurrencyCode;
    public Float requestAmount;
    public String convertedCurrencyCode;
    public Float convertedAmount;
    public List<PaymentOption> paymentOptions = null;
    public Integer chargeRequestID;
    public String postValidationInstructions;

    public Integer getChargeRequestID() {
        return chargeRequestID;
    }

    public void setChargeRequestID(Integer chargeRequestID) {
        this.chargeRequestID = chargeRequestID;
    }

    public String getPostValidationInstructions() {
        return postValidationInstructions;
    }

    public void setPostValidationInstructions(String postValidationInstructions) {
        this.postValidationInstructions = postValidationInstructions;
    }

    public Integer getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public void setCheckoutRequestID(Integer checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }

    public String getMerchantTransactionID() {
        return merchantTransactionID;
    }

    public void setMerchantTransactionID(String merchantTransactionID) {
        this.merchantTransactionID = merchantTransactionID;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getOriginalCurrencyCode() {
        return originalCurrencyCode;
    }

    public void setOriginalCurrencyCode(String originalCurrencyCode) {
        this.originalCurrencyCode = originalCurrencyCode;
    }

    public Float getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(Float requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getConvertedCurrencyCode() {
        return convertedCurrencyCode;
    }

    public void setConvertedCurrencyCode(String convertedCurrencyCode) {
        this.convertedCurrencyCode = convertedCurrencyCode;
    }

    public Float getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Float convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public List<PaymentOption> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(List<PaymentOption> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }
}
