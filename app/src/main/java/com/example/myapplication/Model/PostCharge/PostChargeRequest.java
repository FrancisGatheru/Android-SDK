package com.example.myapplication.Model.PostCharge;

import lombok.Data;

@Data
public class
PostChargeRequest {
    public String merchantTransactionID;
    public Integer checkoutRequestID;
    public String chargeMsisdn;
    public Double chargeAmount;
    public String currencyCode;
    public Integer payerModeID;
    public String languageCode;

    public PostChargeRequest(String merchantTransactionID, Integer checkoutRequestID, String chargeMsisdn, Double chargeAmount, String currencyCode, Integer payerModeID, String languageCode) {
        this.merchantTransactionID = merchantTransactionID;
        this.checkoutRequestID = checkoutRequestID;
        this.chargeMsisdn = chargeMsisdn;
        this.chargeAmount = chargeAmount;
        this.currencyCode = currencyCode;
        this.payerModeID = payerModeID;
        this.languageCode = languageCode;
    }
}


