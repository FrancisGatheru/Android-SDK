package com.example.myapplication.Model;

import java.util.UUID;

public class UniqueIdGenerator {
    /*
    * generate random id's for transactions.
    * test purposes - uniqueIDs
    * */
    public String generateId() {
        String randomID = String.valueOf(UUID.randomUUID());
        String merchantRandID = randomID.replace("-", "");
        return merchantRandID.substring(0, Math.min(merchantRandID.length(), 8));
    }
}
