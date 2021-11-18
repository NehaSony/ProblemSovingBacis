package hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Neha.Sony
 */

public class LeftRotation {
    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        List<Integer> rotatedList= new LinkedList();
        for(int i=0;i<a.size();i++){
            if(i+d<a.size()){
                rotatedList.add(a.get(i+d));
            }else{
                rotatedList.add(a.get(Math.abs(a.size()-i-d)));
            }
        }
        return rotatedList;

    }

    public static void main(String[] args) {
        System.out.println(rotLeft(Arrays.asList(1,2,3,4,5),2));
    }
}
