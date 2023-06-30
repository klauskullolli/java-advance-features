package com.sda.java.advance.opp.taxonomy.enumExample;



public enum Coffee {
    LATTE(4, "e embel"),
    ESPRESSO(2, "e mesme"),
    AMERICANO(3, "pa sheqer") ;

    private   final int value;
    private final  String description;
    Coffee(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
