package com.example.myapplication.Model.cancelrequest;

import lombok.Data;

@Data
public class cancelRequest {


        public String MerchantTransactionID;
        public String serviceCode;
        public int checkoutRequestID;


        public cancelRequest(String merchantTransactionID, int checkoutRequestID, String serviceCode) {
            this.MerchantTransactionID = merchantTransactionID;
            this.serviceCode = serviceCode;
            this.checkoutRequestID = checkoutRequestID;


        }

        public String getMerchantTransactionID() { return MerchantTransactionID ; }

        public void setMerchantTransactionID(String merchantTransactionID) {
            this.MerchantTransactionID = merchantTransactionID;
        }

        public int getCheckoutRequestID() {
            return checkoutRequestID;
        }

        public void setCheckoutRequestID(int checkoutRequestID) {
            this.checkoutRequestID = checkoutRequestID;
        }

        public String getServiceCode() { return serviceCode; }

        public void setServiceCode(String ServiceCode) {
            this.serviceCode = serviceCode;
        }




}

