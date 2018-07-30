package com.thoughtworks.training;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberProcessor {
    private final ArrayList<Processor> processors;

    public NumberProcessor(ArrayList<Processor> processors) {
        this.processors = processors;
    }
//    public int test(){
//        return 0;
//    }

    //    public static void main(String[] args) throws IOException
//    {
//        BufferedReader reader =
//                new BufferedReader(new InputStreamReader(System.in));
//        String input = reader.readLine();
//
//        Scanner scanner = new Scanner(System.in);
//
//
//        String[] num = input.split(" ");
//
//        for(int i = 0;i<num.length;i++)
//        {
//            if(Integer.parseInt(num[i]) % 2 != 0)
//            {
//                System.out.println(num[i]);
//            }
//        }

    public static void main(String[] args) throws IOException {
//        new NumberProcessor().Processor(new Scanner(System.in).nextLine());
        NumberProcessor processor = new NumberProcessor( new ArrayList<Processor>(){{ add(new Add()); }});


        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
        String line;
        while((line =in.readLine()).length() != 0)
        {
           System.out.println(processor.process(line));
        }



    }

        String process(String s) {
        List<Integer> res = Arrays.asList(s.split(" ")).stream().map(Integer::valueOf)
                .collect(Collectors.toList());
            List<Integer> middleResult = new ArrayList<>();
        for(Processor processors:this.processors)
        {
            middleResult = processors.process(res);
            res = middleResult;
        }



       List<String> result = middleResult.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println(String.join(" ", result));
        return String.join(" ", result);
    }

//    String process(String s) {
//        List<String> res = Arrays.asList(s.split(" ")).stream().map(Integer::valueOf)
//                .filter(integer -> integer % 2 != 0)
//                .map(Integer -> Integer+2)
//                .map(String::valueOf)
//                .collect(Collectors.toList());
//        return String.join(" ", res);
//    }

//    private class Mapper implements Function<String, Integer> {
//        @Override
//        public Integer apply(String s) {
//            return Integer.valueOf(s);
//        }
//    }
}

