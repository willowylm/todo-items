package com.thoughtworks.training;


import java.util.List;
import java.util.stream.Collectors;

public class Add implements Processor {
    @Override
    public List<Integer> process(List<Integer> input) {
        return input.stream().map(Integer -> Integer+2)
                .collect(Collectors.toList());
    }


}
