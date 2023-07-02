package com.sda.java.advance.generics;

import java.util.Map;

/**
 * Adding generic type int interface: is same analogy as adding into class
 * Interface, class and methods may have a lot of generics in same time
 * They are defined as below code example using most of time a standardized convention (described
 * and explained in slides )
 * **/
public interface Util<K,V> {
    V getValue(Map<K,V> map, K key);
}
