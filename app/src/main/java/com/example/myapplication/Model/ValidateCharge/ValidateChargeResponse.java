
package com.example.myapplication.Model.ValidateCharge;

import com.example.myapplication.Model.PostCharge.Results;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidateChargeResponse {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("results")
    @Expose
    private Results results;

    public ValidateChargeResponse(Status status, Results results) {
        this.status = status;
        this.results = results;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

}
