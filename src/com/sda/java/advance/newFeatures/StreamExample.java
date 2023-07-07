package com.sda.java.advance.newFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        int a[] =  {3, 4, 5, 6,7};
        Stream<Integer> s1= Arrays.stream(a).boxed();
        s1
                .map(e->e*e)
                .filter(e->e>20)
                .forEach(e -> {System.out.println(e);});

        Stream<Stream> s2 =  Stream.of(Stream.of(2,3,4,5), Stream.of(6,8,9,12)) ;
        Stream<Integer> s3 = s2.flatMap(stream -> stream.distinct());
        s3.forEach(e -> System.out.println(e));

        List<String> stringList =  new ArrayList<>(Arrays.asList("Student", "Klaus", "Hello", "Word"));

        List<String> letters =  stringList.stream()
                .map(str->str.split(""))
                .flatMap(arr-> Arrays.stream(arr))
                .sorted((String o1 , String o2)->{return o2.compareTo(o1);})
                .collect(Collectors.toList());
        System.out.println(letters);

    }
}
