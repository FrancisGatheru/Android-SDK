package com.example.myapplication.Service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.Model.DataSets;
import com.example.myapplication.Model.QueryRequest.QueryResponseStatus;
import com.example.myapplication.Model.cancelrequest.cancelRequest;
import com.example.myapplication.Network.CheckoutClient;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class initiateCancelRequest {
    int checkoutRequestID = DataSets.checkoutRequestID;
    String merchantTransactionID = DataSets.merchantTransactionID;
    String serviceCode = DataSets.serviceCode;

    public void cancelRequest() {
        try {

            cancelRequest cancelRequest =
                    new cancelRequest(
                            merchantTransactionID,
                            checkoutRequestID,
                            serviceCode

                    );
            Log.i("CANCEL-REQUEST", String.format("ENTITIES PREPARED FOR POST: -> \nAuthorisation = %s\ncancelRequest Payload = %s", DataSets.getAccessToken(), cancelRequest));
            Call<QueryResponseStatus> call = CheckoutClient.initCheckoutApi().cancelRequest(String.format("Bearer %s", DataSets.getAccessToken()), cancelRequest);
            call.enqueue(new Callback<>() {
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

