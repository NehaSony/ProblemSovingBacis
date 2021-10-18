package hackerrank;/**
 * @author Neha Sony
 */

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Neha.Sony
 */

public class PdfViewer {
    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        char[] letterArray = word.toCharArray();
        PdfViewer sol = new PdfViewer();
        List<Integer> score = new ArrayList();
        for(char letter:letterArray){
            score.add(h.get(sol.getIndex(letter)));
        }
        Collections.sort(score,Comparator.reverseOrder());
        return score.get(0)*letterArray.length;
    }

    private int getIndex(char letter){
        int index;
        index=letter-97;
        return index;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = PdfViewer.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
