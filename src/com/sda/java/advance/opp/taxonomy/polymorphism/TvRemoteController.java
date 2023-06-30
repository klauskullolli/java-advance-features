package com.sda.java.advance.opp.taxonomy.polymorphism;

public class TvRemoteController implements RemoteController{

    private  String tvType;

    public TvRemoteController(String tvType) {
        this.tvType = tvType;
    }

    public String getTvType() {
        return tvType;
    }

    public void setTvType(String tvType) {
        this.tvType = tvType;
    }

    @Override
    public void enable(boolean enable) {
        if(enable)
            System.out.println("TV of type: " + tvType  + " is turned on");
        else{
            System.out.println("TV of type: " + tvType  + " is turned off");
        }


    }
}
