import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Neha.Sony
 */

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int sum=0;
        list.forEach((listItem)->{
            System.out.println(listItem);
        });
        System.out.println(getIndex('d'));

    }

    private static int getIndex(char letter){
        int index;
        index=letter-97;
        return index;
    }



}
