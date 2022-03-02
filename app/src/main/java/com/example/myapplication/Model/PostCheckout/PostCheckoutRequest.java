package com.example.myapplication.Model.PostCheckout;

import lombok.Data;

@Data
public class PostCheckoutRequest {

    public String merchantTransactionID;
    public Float requestAmount;
    public String currencyCode;
    public String accountNumber;
    public String serviceCode;
    public String dueDate;
    public String requestDescription;
    public String countryCode;
    public String customerFirstName;
    public String customerLastName;
    public String MSISDN;
    public String customerEmail;
    public String paymentWebhookUrl;
    public String successRedirectUrl;
    public String failRedirectUrl;

    public PostCheckoutRequest(String merchantTransactionID, Float requestAmount, String currencyCode, String accountNumber, String serviceCode, String dueDate, String requestDescription, String countryCode, String customerFirstName, String customerLastName, String MSISDN, String customerEmail, String paymentWebhookUrl, String successRedirectUrl, String failRedirectUrl) {
        this.merchantTransactionID = merchantTransactionID;
        this.requestAmount = requestAmount;
        this.currencyCode = currencyCode;
        this.accountNumber = accountNumber;
        this.serviceCode = serviceCode;
        this.dueDate = dueDate;
        this.requestDescription = requestDescription;
        this.countryCode = countryCode;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.MSISDN = MSISDN;
        this.customerEmail = customerEmail;
        this.paymentWebhookUrl = paymentWebhookUrl;
        this.successRedirectUrl = successRedirectUrl;
        this.failRedirectUrl = failRedirectUrl;
    }

}
