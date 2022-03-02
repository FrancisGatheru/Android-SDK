package com.example.myapplication.Service;

import static com.example.myapplication.Model.Constants.CLIENT_ID;
import static com.example.myapplication.Model.Constants.CLIENT_SECRET;
import static com.example.myapplication.Model.Constants.GRANT_TYPE;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.Model.Credentials.CredentialsRequest;
import com.example.myapplication.Model.Credentials.CredentialsResponse;
import com.example.myapplication.Model.DataSets;
import com.example.myapplication.Network.CheckoutClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthenticateUser {

    //work in progress
    public static void valueExistsInArr(Object[] arr, String checkValue) {
        /*check if specified element is present
         * using linear search method
         * returns true or false after search
         */
        boolean checker = false;
        for (Object element : arr) {
            if (element.equals(checkValue)) {
                checker = true;
                break;
            }
        }
        //print result
        System.out.println("Is " + checkValue + " present in array: " + checker);
    }

    public void authenticateRequest() { //pass arguments for user input(credentials)
        try {
            CredentialsRequest credentialsRequest = new CredentialsRequest(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET);
            System.out.println(credentialsRequest);
            Call<CredentialsResponse> callAuth = CheckoutClient.initCheckoutApi().authenticateRequest(credentialsRequest);
            callAuth.enqueue(new Callback<CredentialsResponse>() {
                @Override
                public void onResponse(@NonNull Call<CredentialsResponse> call, @NonNull Response<CredentialsResponse> response) {
                    if (response.isSuccessful() && response.code() == 200) { //check auth status
                        assert response.body() != null;
                        String authToken = (response.body().getAccess_token());
                        Log.d("BEARER TOKEN", "Success getting Auth token: " + authToken);
                        DataSets.setAccessToken(authToken);
                        System.out.println("Did We transmit data ->| " + DataSets.getAccessToken() + " |<-  encapsulation");
                    }
                    String checkNotEmpty = DataSets.getAccessToken();
                    if (!checkNotEmpty.isEmpty()) {
                        PostCheckout postCheckout = new PostCheckout();
                        postCheckout.formulateCheckoutReq();
                    }
                    Object authResponse = new Gson().toJson(response.body());
                    String checkValue = "access_token";
                }

                @Override
                public void onFailure(@NonNull Call<CredentialsResponse> call, @NonNull Throwable t) {
                    Log.i("AUTH FAIL", "Failure to get Access Token", t);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
