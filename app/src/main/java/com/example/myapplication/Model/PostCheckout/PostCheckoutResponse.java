package com.example.myapplication.Model.PostCheckout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PostCheckoutResponse {

    public Status status;
    public Results results;

    public PostCheckoutResponse(Status status, Results results) {
        this.status = status;
        this.results = results;
    }
}
