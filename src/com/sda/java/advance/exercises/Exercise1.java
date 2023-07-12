package com.sda.java.advance.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {


//    Sorting elements of a string list  from z to a
//    First convert to lower case than make the comparison using sort of lists
    private static void sortStringArrayFromZtoA(List<String> arr){
//        arr.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });

//        Using only list manipulations
        int i = 0 ;

        for (String  s1 : arr){
            arr.set(i, s1.toLowerCase());
            i++;
        }

        arr.sort((a1,a2) ->a2.compareTo(a1));    // ASCII
    }

    private static List<String> sortStringArrayFromZtoA2(List<String> arr){
//        Using streams and list
//        arr =  arr.stream().map(e -> e.toLowerCase()).collect(Collectors.toList());  //streams actions
//        arr.sort((a1,a2) ->a2.compareTo(a1));    // ASCII

//        Using only streams
        return arr.stream().map(e -> e.toLowerCase()).sorted((a1 , a2) -> a2.compareTo(a1)).collect(Collectors.toList());
    }


    private  static void  sortCaseSensitive(List<String> arr){
        arr.sort((a1, a2) -> a2.compareTo(a1));
    }


    public static void main(String[] args) {

        List<String> arr  =  new ArrayList<>(Arrays.asList("hello", "word", "here", "SDA", "test")) ;

        List<String> arr1 =  new ArrayList<>(arr);


        System.out.println("arr -> " +  arr);
        sortStringArrayFromZtoA(arr);

        System.out.println("arr (after sorting) ->" + arr);

        arr =  sortStringArrayFromZtoA2(arr) ;

        System.out.println("arr (after sorting 1) ->" + arr);

        sortCaseSensitive(arr1);
        System.out.println("array sort case sensitive ->" + arr1);


    }
}
