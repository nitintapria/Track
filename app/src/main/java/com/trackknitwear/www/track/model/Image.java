package com.trackknitwear.www.track.model;

import java.io.Serializable;

public class Image implements Serializable{
    private String code;
    private int image;


    public Image(String code, int image) {
        this.code = code;
        this.image = image;
    }

    public String getCode() {
        return code;
    }


    public int getImage() {
        return image;
    }

}