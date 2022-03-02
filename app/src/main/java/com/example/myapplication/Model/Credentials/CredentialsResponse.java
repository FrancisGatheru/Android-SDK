package com.example.myapplication.Model.Credentials;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Data;

@Data
public class CredentialsResponse implements Parcelable {


    private String token_type;
    private int expires_in;
    private String access_token;


    protected CredentialsResponse(Parcel in) {
        token_type = in.readString();
        expires_in = in.readInt();
        access_token = in.readString();
    }

    public static final Creator<CredentialsResponse> CREATOR = new Creator<CredentialsResponse>() {
        @Override
        public CredentialsResponse createFromParcel(Parcel in) {
            return new CredentialsResponse(in);
        }

        @Override
        public CredentialsResponse[] newArray(int size) {
            return new CredentialsResponse[size];
        }
    };

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(token_type);
        parcel.writeInt(expires_in);
        parcel.writeString(access_token);
    }
}
