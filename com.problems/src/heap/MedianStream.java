package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Neha.Sony
 */

public class MedianStream {

    int[] findMedian(int[] arr) {
        // Write your code here
        int[] medianArray= new int[arr.length];
        Queue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.naturalOrder());
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i =0;i<arr.length;i++){
            addElement(arr[i],minHeap,maxHeap);
            reheapify(minHeap,maxHeap);
            medianArray[i]=getMedian(minHeap,maxHeap);
        }

        return medianArray;
    }

    private void addElement(int i, Queue<Integer> minHeap, Queue<Integer> maxHeap) {
        if(maxHeap.size()==0||i<maxHeap.peek()){
            maxHeap.add(i);
        }else minHeap.add(i);
    }

    private void reheapify(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
        Queue<Integer> biggerHeap = maxHeap.size()>minHeap.size()?maxHeap:minHeap;
        Queue<Integer> smallerHeap = minHeap.size()<maxHeap.size()?minHeap:maxHeap;
        if(biggerHeap.size()-smallerHeap.size()>=2){
            smallerHeap.add(biggerHeap.poll());
        }

    }

    private int getMedian(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
        Queue<Integer> biggerHeap = maxHeap.size()>minHeap.size()?maxHeap:minHeap;
        Queue<Integer> smallerHeap = minHeap.size()<maxHeap.size()?minHeap:maxHeap;
        if(biggerHeap.size()-smallerHeap.size()==0){
            return (biggerHeap.peek()+smallerHeap.peek())/2;
        }
        return biggerHeap.peek();
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }
    public void run() {
        int[] arr_1 = {5, 15, 1, 3};
        int[] expected_1 = {5, 10, 5, 4};
        int[] output_1 = findMedian(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {2, 3, 4, 3, 4, 3};
        int[] output_2 = findMedian(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new MedianStream().run();
    }
}
