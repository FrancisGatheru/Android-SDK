package com.example.myapplication.Model.PostCharge;

import com.example.myapplication.Model.PostCheckout.Results;
import com.example.myapplication.Model.PostCheckout.Status;

import lombok.Data;

@Data
public class PostChargeResponse {
    public Status status;
    public Results results;
}



