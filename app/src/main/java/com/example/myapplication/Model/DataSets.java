package com.example.myapplication.Model;

import lombok.Data;

/*
* perform encapsulation - transfer data between different classes
* Use of getter and setter for data storage and retrieval
* */

@Data
public class DataSets {
    public static String accessToken;
    public static String merchantTransactionID;
    public static int checkoutRequestID;
    public static String originalCurrencyCode;
    public static int chargeRequestID;
    public static String countryCode;
    public static String serviceCode;
    public static int isExecuted;

    public static int getIsExecuted() {
        return isExecuted;
    }

    public static void setIsExecuted(int isExecuted) {
        DataSets.isExecuted = isExecuted;
    }

    public static String getServiceCode() {
        return serviceCode;
    }

    public static void setServiceCode(String serviceCode) {
        DataSets.serviceCode = serviceCode;
    }

    public static String getCountryCode() {
        return countryCode;
    }

    public static void setCountryCode(String countryCode) {
        DataSets.countryCode = countryCode;
    }

    public static int getChargeRequestID() {
        return chargeRequestID;
    }

    public static void setChargeRequestID(int chargeRequestID) {
        DataSets.chargeRequestID = chargeRequestID;
    }

    public static String getOriginalCurrencyCode() {
        return originalCurrencyCode;
    }

    public static void setOriginalCurrencyCode(String originalCurrencyCode) {
        DataSets.originalCurrencyCode = originalCurrencyCode;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        DataSets.accessToken = accessToken;
    }

    public static String getMerchantTransactionID() {
        return merchantTransactionID;
    }

    public static void setMerchantTransactionID(String merchantTransactionID) {
        DataSets.merchantTransactionID = merchantTransactionID;
    }

    public static int getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public static void setCheckoutRequestID(int checkoutRequestID) {
        DataSets.checkoutRequestID = checkoutRequestID;
    }
}
