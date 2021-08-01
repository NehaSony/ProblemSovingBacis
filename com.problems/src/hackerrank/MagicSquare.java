package hackerrank;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class MagicSquareResult {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */
    static final Integer magicConstant=15;

    public static int formingMagicSquare(List<List<Integer>> s) {
        int cost = 0;
        int magicSum;
        for(int i=0;i<s.size();i++) {
            magicSum=0;
            for(int j=0;j<s.size();j++) {
                magicSum = magicSum + s.get(i).get(j);
            }
            if(magicSum!=magicConstant){
                cost=cost+Math.abs(magicSum-magicConstant);
            }
        }

        System.out.println(cost);
        return cost;
    }
}




public class MagicSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/Z002X5H/Documents/Others/test.txt"));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = MagicSquareResult.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
