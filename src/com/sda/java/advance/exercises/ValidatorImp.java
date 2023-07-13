package com.sda.java.advance.exercises;

public class ValidatorImp implements  Validator{
    @Override
    public boolean validate(Parcel p) {


        boolean  eachDimBigThirty = p.getxLength()>30 && p.getyLength()>30 && p.getzLength()>30;
        boolean lessSumThreeHund = (p.getxLength()  + p.getyLength() + p.getzLength()) < 300;
        boolean weightConstraint =  (p.getWeight()<30 && !p.isExpress()) || (p.getWeight()<15 && p.isExpress());

        if (eachDimBigThirty && lessSumThreeHund  && weightConstraint){
            return true;
        }

        return false;
    }
}
