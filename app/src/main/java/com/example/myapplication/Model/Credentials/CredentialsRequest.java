package com.example.myapplication.Model.Credentials;

import lombok.Data;

@Data
public class CredentialsRequest {

    private String grant_type;

    private String client_id;

    private String client_secret;

    public CredentialsRequest(String grant_type, String client_id, String client_secret) {
        this.grant_type = grant_type;
        this.client_id = client_id;
        this.client_secret = client_secret;
    }
}
