package hackerrank;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

    class Results {

        /*
         * Complete the 'plusMinus' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */
        public static void plusMinus(List<Integer> arr) {
            // Write your code here
            AtomicInteger positive = new AtomicInteger();
            AtomicInteger negative = new AtomicInteger();
            AtomicInteger zero = new AtomicInteger();
            arr.forEach(e->{
                if(e>0)
                    positive.getAndIncrement();
                if(e<0)
                    negative.getAndIncrement();
                if(e==0)
                    zero.getAndIncrement();
            });
            Float cal =0.000000f;
            cal =Float.valueOf(positive.get()) /arr.size();
            System.out.println(cal);
            cal = Float.valueOf(negative.get()) /arr.size();
            System.out.println(cal);
            cal = Float.valueOf(zero.get()) /arr.size();
            System.out.println(cal);
        }
    }

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Results.plusMinus(arr);

        bufferedReader.close();
    }
}
