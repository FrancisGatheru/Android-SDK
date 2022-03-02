package com.example.myapplication.Service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.Model.DataSets;
import com.example.myapplication.Model.QueryRequest.QueryRequestStatus;
import com.example.myapplication.Model.QueryRequest.QueryResponseStatus;
import com.example.myapplication.Network.CheckoutClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QueryPaymentStatus {

    static int checkStatus;

    public void queryStatusOfPayment() {

        System.out.println("Are we reaching here?");

        int checkoutRequestId = DataSets.getCheckoutRequestID();

        QueryRequestStatus queryRequestStatus =
                new QueryRequestStatus(
                        DataSets.getMerchantTransactionID(),
                        DataSets.getServiceCode(),
                        Integer.toString(checkoutRequestId)
                );

        try{
            Log.i("QUERYSTATUS", String.format("ENTITIES PREPARED FOR POST: -> \nAuthorisation = %s\nQueryStatus Payload = %s", DataSets.getAccessToken(), queryRequestStatus));
            Call<QueryResponseStatus> call = CheckoutClient.initCheckoutApi().queryRequestStatus(String.format("Bearer %s", DataSets.getAccessToken()), queryRequestStatus);
            call.enqueue(new Callback<QueryResponseStatus>() {
                @Override
                public void onResponse(@NonNull Call<QueryResponseStatus> call, @NonNull Response<QueryResponseStatus> response) {
                    assert response.body() != null;
                    checkStatus = response.body().status.getStatusCode();
                    Log.i("QUERYSTATUS", String.format("RETRIEVED OBJECTS AFTER POST: -> %s", new Gson().toJson(response.body())));
                }

                @Override
                public void onFailure(@NonNull Call<QueryResponseStatus> call, @NonNull Throwable t) {
                    Log.d("FAIL QUERYSTATUS", "STATUS NOT SUCCESSFUL DUE TO: -> " + checkStatus);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
