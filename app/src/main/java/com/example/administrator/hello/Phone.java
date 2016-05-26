package com.example.administrator.hello;

/**
 * Created by Administrator on 2016/5/23.
 */
public class Phone {
    private String phoneNumber;
    private String band;
    private String imei;
    private String imsi;

    public Phone(String imei, String imsi) {
        this.imei = imei;
        this.imsi = imsi;
    }

    public Phone(String phoneNumber, String band, String imei, String imsi) {
        this.phoneNumber = phoneNumber;
        this.band = band;
        this.imei = imei;
        this.imsi = imsi;
    }
}
