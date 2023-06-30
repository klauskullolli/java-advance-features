package com.sda.java.advance.opp.taxonomy.enumExample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/*
* This is a way how to create an annotation using @interface
* Usually are used only to maintain metadata and have no effect in code
* Also may have restriction for placement: at method, at field, at class etc
* Restriction for usage: in runtime if are used for configuration
* Otherwise just for source code for better understanding and code organization
* */

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface CustomErrorAnnotation {
    String getMessage();
    Class  myClass();
}
