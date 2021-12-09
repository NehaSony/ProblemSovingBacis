package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Neha.Sony
 */

public class AverageSlidingWindow {
    public List<Double> listOfAverage(List<Integer> inputList, Integer windowSize){
        List<Double> averageList  = new LinkedList<Double>();
        Integer sum = 0;
        Integer count = 0;
        Integer prev =0;
        for(int i = 0; i<windowSize+count && i<inputList.size(); i++){
            prev=inputList.get(count);
            sum = sum+ inputList.get(i);
            if(i==windowSize+count-1){
                count++;
                sum-=prev;
                averageList.add((double)sum/windowSize);
            }
        }
        return averageList;
    }

    public static void main(String[] args) {
        AverageSlidingWindow averageSlidingWindow = new AverageSlidingWindow();
        System.out.println(averageSlidingWindow.listOfAverage(Arrays.asList(1, 3, 4, 5),2));
    }
}
