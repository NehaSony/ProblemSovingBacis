package sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSort {

    public void mergeSort(int[] array,int[] temp){
        mergeSort(array,temp,0,array.length-1);
    }

    private void mergeSort(int[] array,int[] temp, int leftStart, int rightEnd) {
        if(leftStart>=rightEnd){
            return;
        }
        int middle = (leftStart+rightEnd)/2;
        mergeSort(array,temp,leftStart,middle);
        mergeSort(array,temp,middle+1,rightEnd);
        mergeHalves(array,temp,leftStart,rightEnd);
    }

    private void mergeHalves(int[] array,int[] temp, int leftStart, int rightEnd) {

        int leftend = (rightEnd+leftStart)/2;
        int rightstart = leftend+1;
        int size = rightEnd-leftStart+1;

        int index = leftStart;
        int left =leftStart;
        int right = rightstart;

        while (left<=leftend&&right<=rightEnd){
            if(array[left]<=array[right]){
                temp[index]=array[left];
                left++;
            } else {
                temp[index]=array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array,left,temp,index,leftend-left+1);
        System.arraycopy(array,right,temp,index,rightEnd-right+1);
        System.arraycopy(temp,leftStart,array,leftStart,size);
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] input = new int[]{3,5,1,9,8,6};
        int[] temp = new int[input.length];
        m.mergeSort(input,temp);
        Arrays.stream(input).forEach(System.out::println);
    }

}
