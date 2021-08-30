package com.baidu.cie.superarchive.v2.web.identify;

public class IdentifyOperatorHandle extends ImageSearchDoc {
    static {
        try {
            System.out.println("loading so ...");
            System.load("/home/big-data/javajars/identify/libSearchDocAPI.so");
            System.out.println("loading so finished.");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load libSearchDocAPI.so !");
        }
    }
}
