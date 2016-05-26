package com.example.administrator.hello;

/**
 * Created by Administrator on 2016/5/22.
 */
public class Info {
    private  String imgHeader;
    private  String txt;

    public Info(String imgHeader, String txt) {
        this.imgHeader = imgHeader;
        this.txt = txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setImgHeader(String imgHeader) {
        this.imgHeader = imgHeader;
    }

    public String getImgHeader() {

        return imgHeader;
    }

    public String getTxt() {
        return txt;
    }
}
