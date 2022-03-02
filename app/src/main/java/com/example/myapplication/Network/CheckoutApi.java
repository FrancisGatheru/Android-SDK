package com.example.myapplication.Network;

import com.example.myapplication.Model.Credentials.CredentialsRequest;
import com.example.myapplication.Model.Credentials.CredentialsResponse;
import com.example.myapplication.Model.InitiateRefund.InitiateRefundRequest;
import com.example.myapplication.Model.PostCharge.PostChargeRequest;
import com.example.myapplication.Model.PostCharge.PostChargeResponse;
import com.example.myapplication.Model.PostCheckout.PostCheckoutRequest;
import com.example.myapplication.Model.PostCheckout.PostCheckoutResponse;
import com.example.myapplication.Model.QueryRequest.QueryRequestStatus;
import com.example.myapplication.Model.QueryRequest.QueryResponseStatus;
import com.example.myapplication.Model.ValidateCharge.ValidateChargeRequest;
import com.example.myapplication.Model.ValidateCharge.ValidateChargeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/*
* Checkout Network Interface
* */
public interface CheckoutApi {

    @POST("oauth/token")
    Call<CredentialsResponse> authenticateRequest(//authentication call
            @Body CredentialsRequest credentialsRequest
    );

    @POST("requests/initiate")
    Call<PostCheckoutResponse> checkoutRequest(//post-checkout
            @Header("Authorization") String accessToken,
            @Body PostCheckoutRequest postCheckoutRequest
    );

    @POST("requests/charge")
    Call<PostChargeResponse> chargeRequest(//post-charge
            @Header("Authorization") String accessToken,
            @Body PostChargeRequest postChargeRequest
    );

    @POST("requests/validate-charge")
    Call<ValidateChargeResponse> validateChargeRequest(//validate-charge
            @Header("Authorization") String accessToken,
            @Body ValidateChargeRequest validateChargeRequest
    );

    @POST("requests/query-status")
    Call<QueryResponseStatus> queryRequestStatus(
            @Header("Authorization") String accessToken,
            @Body QueryRequestStatus queryRequestStatus
    );

    @POST("requests/initiate-refund")
    Call<QueryResponseStatus> initiateRefund(
            @Header("Authorization") String accessToken,
            @Body InitiateRefundRequest initiateRefundRequest
    );

}
