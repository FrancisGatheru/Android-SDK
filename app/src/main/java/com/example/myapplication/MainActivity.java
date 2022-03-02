package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Service.AuthenticateUser;
import com.example.myapplication.Service.InitiateRefund;
import com.jakewharton.threetenabp.AndroidThreeTen;

//main runnable class
public class MainActivity extends AppCompatActivity {
    AuthenticateUser authenticateUser = new AuthenticateUser();
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidThreeTen.init(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authenticateUser.authenticateRequest();

        /*
        * invoke initiate refund
        * runs independently as per the merchant's need
        * post delay request for test purpose
        * */
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                InitiateRefund initiateRefund = new InitiateRefund();
                initiateRefund.requestInitiateRefund();
            }
        }, 12000);
    }

}

