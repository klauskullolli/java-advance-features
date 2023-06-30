package com.sda.java.advance.opp.taxonomy.polymorphism;

public class AcRemoteController implements RemoteController{
    private  String acType;

    public AcRemoteController(String acType) {
        this.acType = acType;
    }

    @Override
    public void enable(boolean enable) {
        if(enable)
            System.out.println("AC of type: " + acType  + " is turned on");
        else{
            System.out.println("AC of type: " + acType  + " is turned off");
        }
    }


    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }
}
