package com.openelements.dbch;

import com.hedera.hashgraph.sdk.PrecheckStatusException;

import java.util.concurrent.TimeoutException;

public class Caller {
    public static void main(String[] args) throws PrecheckStatusException, TimeoutException {
        for(int i = 0; i < 10; i ++){
            HederaExamples.callPrint();
            System.out.println("\n");
        }
    }
}
