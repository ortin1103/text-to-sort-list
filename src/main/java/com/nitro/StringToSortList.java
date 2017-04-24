package com.nitro;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StringToSortList {
     public List<String> collect(String text){
         List<String> collection = Arrays.asList(text.split("(\\s|$)"));

         double asDouble = collection.stream().mapToInt(String::length).average().getAsDouble();

         List<String> collectNums = collection.stream().filter(s -> s.matches("(\\d+)(.*)")).filter(s -> s.length()>=asDouble)
                 .sorted(Comparator.comparing((s)->-s.length())).collect(Collectors.toList());

         List<String> collectString = collection.stream().filter(s -> !s.matches("(\\d+)(.*)")).filter((s) -> s.length() >= asDouble)
                 .sorted(Comparator.comparing(s ->-s.length()))
                 .collect(Collectors.toList());
         return Stream.of(collectNums,collectString).flatMap(s->s.stream()).collect(Collectors.toList());
    }
}
