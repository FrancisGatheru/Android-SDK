package com.example.myapplication.Model.PostCharge;

import lombok.Data;

@Data
public class Results {
    public Integer checkoutRequestID;
    public String merchantTransactionID;
    public Integer chargeRequestID;
    public String paymentInstructions;
    public String languageCode;
    public Integer chargeMsisdn;
    public Integer chargeAmount;
    public String chargeRequestDate;
    public String paymentRedirectUrl;

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

    public Integer getChargeRequestID() {
        return chargeRequestID;
    }

    public void setChargeRequestID(Integer chargeRequestID) {
        this.chargeRequestID = chargeRequestID;
    }

    public String getPaymentInstructions() {
        return paymentInstructions;
    }

    public void setPaymentInstructions(String paymentInstructions) {
        this.paymentInstructions = paymentInstructions;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Integer getChargeMsisdn() {
        return chargeMsisdn;
    }

    public void setChargeMsisdn(Integer chargeMsisdn) {
        this.chargeMsisdn = chargeMsisdn;
    }

    public Integer getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Integer chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public String getChargeRequestDate() {
        return chargeRequestDate;
    }

    public void setChargeRequestDate(String chargeRequestDate) {
        this.chargeRequestDate = chargeRequestDate;
    }

    public String getPaymentRedirectUrl() {
        return paymentRedirectUrl;
    }

    public void setPaymentRedirectUrl(String paymentRedirectUrl) {
        this.paymentRedirectUrl = paymentRedirectUrl;
    }
}
