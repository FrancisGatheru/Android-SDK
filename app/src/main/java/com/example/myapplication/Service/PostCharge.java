package com.example.myapplication.Service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.Model.DataSets;
import com.example.myapplication.Model.PostCharge.PostChargeRequest;
import com.example.myapplication.Model.PostCharge.PostChargeResponse;
import com.example.myapplication.Model.UniqueIdGenerator;
import com.example.myapplication.Model.ValidateCharge.ValidateChargeRequest;
import com.example.myapplication.Model.ValidateCharge.ValidateChargeResponse;
import com.example.myapplication.Network.CheckoutClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostCharge {

    static int checkStatus;
    /*
     * Method to be invoked on user's own choice
     * Callable from parent class @PostCharge
     * co-dependent on parent class for invocation
     * i.e can't be called before first method (postChargeReq)!
     * */
    UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();

    /*
     * Initiate post charge API call
     * Formulate post charge request payload
     * */
    public void formulatePostChargeReq() {
        PostChargeRequest postChargeRequest =
                new PostChargeRequest( //values retrieved from DataSets rely on previous post checkout response.
                        DataSets.getMerchantTransactionID(),
                        DataSets.getCheckoutRequestID(),
                        "254721863288",
                        159.50,
                        DataSets.getOriginalCurrencyCode(),
                        56,
                        "en"
                );

        Log.i("POSTCHARGE", String.format("ENTITIES PREPARED FOR POST: -> \nAuthorisation = %s\nPostCharge Payload = %s", DataSets.getAccessToken(), postChargeRequest));
        Call<PostChargeResponse> call = CheckoutClient.initCheckoutApi().chargeRequest("Bearer " + DataSets.getAccessToken(), postChargeRequest);
        call.enqueue(new Callback<PostChargeResponse>() {
            @Override
            public void onResponse(@NonNull Call<PostChargeResponse> call, @NonNull Response<PostChargeResponse> response) {
                if (response.isSuccessful()) {
                    assert null != response.body();
                    checkStatus = response.body().status.getStatusCode();
                    Log.i("POSTCHARGE", "RETRIEVED OBJECTS AFTER POST: -> " + new Gson().toJson(response.body()));
                }

                assert response.body() != null;
                int chargeRequestID = response.body().results.getChargeRequestID();
                String countryCode = DataSets.getCountryCode();
                System.out.println("What's my current country code: -> " + countryCode);
                //validate country code before proceeding to validate post charge request.
                if (checkStatus == 200 && !(chargeRequestID <= 1) && countryCode.equals("GH")) {
                    DataSets.setChargeRequestID(chargeRequestID);
                    //test validate charge works!
                    validateChargeRequest();
                } else {
                    Log.i("VALIDATE-CHARGE", "Country set does not match GH");
                }

                /*
                 * introduce spy to check if function has been executed.
                 * implement on and off concept in datasets.
                 * */
                DataSets.setIsExecuted(1);
                System.out.println("Am the spy!");

                /*
                 * check if current isExecuted-flag isEqual to 1
                 * if isExecuted = true -> perform queryRequestStatus
                 * then reset isExecuted to initial 0
                 * */
                System.out.println("Spy Xenzia on her way");
                if (DataSets.getIsExecuted() == 1) {
                    QueryPaymentStatus queryPaymentStatus = new QueryPaymentStatus();
                    queryPaymentStatus.queryStatusOfPayment();
                }
                DataSets.setIsExecuted(0);
            }

            @Override
            public void onFailure(@NonNull Call<PostChargeResponse> call, @NonNull Throwable t) {
                Log.d("POSTCHARGE", String.format("FAILURE ON POSTCHARGE: -> %s", t.getMessage()));
            }
        });
    }

    public void validateChargeRequest() {//validates earlier authorized charge
        String checkoutRequestID = Integer.toString(DataSets.getCheckoutRequestID());
        try {
            ValidateChargeRequest validateChargeRequest =
                    new ValidateChargeRequest( //all params ? rely on parsed values in previous post charge
                            DataSets.getMerchantTransactionID(),
                            checkoutRequestID,
                            DataSets.getChargeRequestID(),
                            DataSets.getAccessToken()
                    );

            Log.i("VALIDATE-CHARGE", String.format("ENTITIES PREPARED FOR POST: -> \nAuthorisation = %s\nPostValidate-Charge Payload = %s", DataSets.getAccessToken(), validateChargeRequest));
            Call<ValidateChargeResponse> call = CheckoutClient.initCheckoutApi().validateChargeRequest("Bearer " + DataSets.getAccessToken(), validateChargeRequest);
            call.enqueue(new Callback<ValidateChargeResponse>() {
                @Override
                public void onResponse(@NonNull Call<ValidateChargeResponse> call, @NonNull Response<ValidateChargeResponse> response) {
                    if (response.isSuccessful()) {
                        assert null != response.body();
                        checkStatus = response.body().getStatus().getStatusCode();
                        Log.i("VALIDATE-CHARGE", "RETRIEVED OBJECTS AFTER POST: -> " + new Gson().toJson(response.body()));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ValidateChargeResponse> call, @NonNull Throwable t) {
                    Log.d("VALIDATE-CHARGE", String.format("FAILURE ON VALIDATE-CHARGE: -> %s", t.getMessage()));
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
