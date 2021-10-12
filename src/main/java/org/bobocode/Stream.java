package org.bobocode;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Stream {
    public static void main(String[] args) {
        Map<String, Long> collect = List.of("Ghb", "ASDQWE", "Gdsf").stream().collect(groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((key,value) -> System.out.println(key + " " + " count = " + value));

    }
}
