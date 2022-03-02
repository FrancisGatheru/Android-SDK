package com.example.myapplication.Service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.Model.DataSets;
import com.example.myapplication.Model.InitiateRefund.InitiateRefundRequest;
import com.example.myapplication.Model.QueryRequest.QueryResponseStatus;
import com.example.myapplication.Model.UniqueIdGenerator;
import com.example.myapplication.Network.CheckoutClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InitiateRefund {
    int checkoutRequestID = DataSets.getCheckoutRequestID();
    UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();
    /*
    * invoked directly by the customer
    * should be invoked independently
    * */
    public void requestInitiateRefund() {
        try {
            InitiateRefundRequest initiateRefundRequest =
                    new InitiateRefundRequest(
                            uniqueIdGenerator.generateId(),
                            String.valueOf(checkoutRequestID),
                            "full",
                            12,
                            DataSets.getCountryCode(),
                            "Wrong payment to merchant",
                            ""
                    );
            Log.i("INITIATE-REFUND", String.format("ENTITIES PREPARED FOR POST: -> \nAuthorisation = %s\nInitiateRefund Payload = %s", DataSets.getAccessToken(), initiateRefundRequest));
            Call<QueryResponseStatus> call = CheckoutClient.initCheckoutApi().initiateRefund(String.format("Bearer %s", DataSets.getAccessToken()), initiateRefundRequest);
            call.enqueue(new Callback<QueryResponseStatus>() {
                @Override
                public void onResponse(@NonNull Call<QueryResponseStatus> call, @NonNull Response<QueryResponseStatus> response) {
                    assert response.body() != null;
                    Object notEmptyResults = response.body().results;
                    if (response.isSuccessful() && response.code() == 200 && notEmptyResults != null) {
                        Log.i("INITIATE-REFUND", String.format("RETRIEVED OBJECTS AFTER POST: -> %s", new Gson().toJson(response.body())));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<QueryResponseStatus> call, @NonNull Throwable t) {
                    Log.e("INITIATE-REFUND", String.format("FAILED RETRIEVING OBJECTS: -> %s", t.getMessage()));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
