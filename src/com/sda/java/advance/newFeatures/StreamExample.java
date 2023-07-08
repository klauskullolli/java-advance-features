package com.sda.java.advance.newFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Streams are very useful for data manipulation
//They use functional programming analogy
public class StreamExample {
    public static void main(String[] args) {
        int a[] = {3, 4, 5, 6, 7};
        Stream<Integer> s1 = Arrays.stream(a).boxed();
        s1
                .map(e -> e * e)  //each value make power
                .filter(e -> e > 20) //filter each value should be bigger than 20
                .forEach(e -> {
                    System.out.println(e);
                });

//        Collect method is used to collect stream to list or other data structure
        List<Integer> l1 = Arrays.stream(a).boxed().map(e -> e * e)
                .filter(e -> e > 20).collect(Collectors.toList());

        System.out.println("L1: " + l1);

        Integer max = Arrays.stream(a).boxed()
                .map(el -> (el + 2) * el)  // add with 2 and multiply with initial value
                .filter(el -> el % 3 == 0)  // filtrojm vlerat qe jan shumfish te 3
                .sorted((e1, e2) -> e2.compareTo(e1))  //sort from biggest to lowest
                .findFirst() // get first object of stream and return optional type
                .get();  // from optional get value using get

        System.out.println("Max: " + max);


        Stream<Stream> s2 = Stream.of(Stream.of(2, 3, 4, 5), Stream.of(6, 8, 9, 12));
        Stream<Integer> s3 = s2.flatMap(stream -> stream.distinct());
        s3.forEach(e -> System.out.println(e));

        List<String> stringList = new ArrayList<>(Arrays.asList("Student", "Klaus", "Hello", "Word"));

        List<String> letters = stringList.stream()
                .map(str -> str.split(""))
                .flatMap(arr-> Arrays.stream(arr))
                .sorted((String o1 , String o2)->{return o2.compareTo(o1);})
                .collect(Collectors.toList());
        System.out.println(letters);

    }
}
