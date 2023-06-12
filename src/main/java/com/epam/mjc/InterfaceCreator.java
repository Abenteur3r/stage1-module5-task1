package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x ->{
            for(String i : x){
                char firstChar = i.charAt(0);
                if(Character.isDigit(firstChar)){
                    return false;
                }
                if((firstChar == Character.toUpperCase(firstChar))){
                    return true;
                }
            }
            return false;

        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> allEven = new ArrayList<>();
            for(Integer i : x){
                if(i%2==0){
                    allEven.add(i);
                }
            }
            x.addAll(allEven);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> res = new ArrayList<>();
            for (String i : values) {
                boolean firstChar = i.charAt(0) == Character.toUpperCase(i.charAt(0));
                boolean lastChar = '.' == i.charAt(i.length() - 1);
                boolean moreThanThree = i.split(" ").length > 3;

                if (firstChar && lastChar && moreThanThree) {
                    res.add(i);
                }
            }
            return res;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> strMap = new HashMap<>();
            for(String i : x){
                strMap.put(i,i.length());
            }
            return strMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1,list2) -> {
            List<Integer> res = new ArrayList<>(list1);
            res.addAll(list2);
            return res;
        };
    }
}
