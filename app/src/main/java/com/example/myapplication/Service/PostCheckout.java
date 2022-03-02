package com.example.myapplication.Service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.Model.DataSets;
import com.example.myapplication.Model.PostCheckout.PostCheckoutRequest;
import com.example.myapplication.Model.PostCheckout.PostCheckoutResponse;
import com.example.myapplication.Model.UniqueIdGenerator;
import com.example.myapplication.Network.CheckoutClient;
import com.google.gson.Gson;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostCheckout {

    static int checkStatus;
    static int checkoutRequestID;
    static String merchantTransID;
    static String originalCurrencyCode;
    static String countryCode;
    static String serviceCode;
    PostCharge postCharge = new PostCharge();

    /*
     * Initiate post checkout API call
     * Formulate post checkout request payload
     * */
    public void formulateCheckoutReq() {
        UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();
        String merchantTransactionID = uniqueIdGenerator.generateId();
        System.out.println("Where is my token -> " + DataSets.getAccessToken() + " <-Wheree?");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime f = dateTime.plusHours(24);
        String futureDate = f.format(dateTimeFormatter);

        try {
            PostCheckoutRequest postCheckoutRequest =
                    new PostCheckoutRequest(
                            merchantTransactionID,
                            159.50F,
                            "KES",
                            "ACC123",
                            "FOODEV2675",
                            futureDate,
                            "Jordan Shoes",
                            "KE",
                            "frsnk",
                            "IanShem",
                            "254721863288",
                            "francisian@gmail.com",
                            "https://webhook.site/fb8ead15-4e7f-432b-97c2-1098e1ac0777",
                            "https://www.google.com/",
                            "https://www.google.com/");

            Log.i("POSTCHECKOUT", String.format("ENTITIES PREPARED FOR POST: -> \nAuthorisation = %s\nPostCheckout Payload = %s", DataSets.getAccessToken(), postCheckoutRequest));
            Call<PostCheckoutResponse> call = CheckoutClient.initCheckoutApi().checkoutRequest(String.format("Bearer %s", DataSets.getAccessToken()), postCheckoutRequest);
            call.enqueue(new Callback<PostCheckoutResponse>() {
                @Override
                public void onResponse(@NonNull Call<PostCheckoutResponse> call, @NonNull Response<PostCheckoutResponse> response) {
                    assert response.body() != null;
                    Object NotEmptyResults = response.body().results;
                    if (response.isSuccessful() && response.code() == 200 && NotEmptyResults != null) {
                        checkStatus = response.body().status.getStatusCode(); //if status is 200 -> proceed to post charge
                        checkoutRequestID = response.body().results.getCheckoutRequestID();
                        merchantTransID = response.body().results.getMerchantTransactionID();
                        originalCurrencyCode = response.body().results.getOriginalCurrencyCode();
                        //get country code to be validated on validate post-charge phase
                        countryCode = response.body().results.getPaymentOptions().get(0).countryCode;
                        //get service code to be posted on query status phase
                        serviceCode = response.body().results.getPaymentOptions().get(0).serviceCode;

                        System.out.println(" is this country code: -> " + countryCode);
                        Log.i("POSTCHECKOUT", String.format("RETRIEVED OBJECTS AFTER POST: -> %s", new Gson().toJson(response.body())));


                        //to avoid null pointer exceptions
                        if (checkStatus == 200 && (!merchantTransID.isEmpty() && checkoutRequestID > 0)) {//if true, proceed to post charge
                            //set shared value from checkout response to charge && validate post-charge request
                            DataSets.setCheckoutRequestID(checkoutRequestID);
                            DataSets.setMerchantTransactionID(merchantTransID);
                            DataSets.setOriginalCurrencyCode(originalCurrencyCode);
                            DataSets.setCountryCode(countryCode);
                            DataSets.setServiceCode(serviceCode);
                            //call post charge
                            postCharge.formulatePostChargeReq();
                        } else {
                            //<default> toast with appropriate message
                            Log.d("FAIL POSTCHARGE", "STATUS NOT SUCCESSFUL DUE TO: -> " + checkStatus);
                        }
                    }

                }

                @Override
                public void onFailure(@NonNull Call<PostCheckoutResponse> call, @NonNull Throwable t) { //most likely to be a http error
                    Log.e("POSTCHECKOUT", String.format("FAILED RETRIEVING OBJECTS: -> %s", t.getMessage()));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
