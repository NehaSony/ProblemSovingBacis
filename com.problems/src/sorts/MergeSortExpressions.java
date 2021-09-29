package sorts;

import java.util.Arrays;

public class MergeSortExpressions {

    public void mergeSort(Expression[] array,Expression[] temp){
        mergeSort(array,temp,0,array.length-1);
    }

    private void mergeSort(Expression[] array,Expression[] temp, int leftStart, int rightEnd) {
        if(leftStart>=rightEnd){
            return;
        }
        int middle = (leftStart+rightEnd)/2;
        mergeSort(array,temp,leftStart,middle);
        mergeSort(array,temp,middle+1,rightEnd);
        mergeHalves(array,temp,leftStart,rightEnd);
    }

    private void mergeHalves(Expression[] array,Expression[] temp, int leftStart, int rightEnd) {

        int leftend = (rightEnd+leftStart)/2;
        int rightstart = leftend+1;
        int size = rightEnd-leftStart+1;

        int index = leftStart;
        int left =leftStart;
        int right = rightstart;

        while (left<=leftend&&right<=rightEnd){
            if(array[left].getKey()<=array[right].getKey()){
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
        MergeSortExpressions m = new MergeSortExpressions();
        Expression[] input = {
                Expression.build("1+2"),
                Expression.build("3*4"),
                Expression.build("5/6"),
                Expression.build("7-8"),
                Expression.build("9+0")};


        Expression[] benchmarkExpressions = new Expression[input.length];
        System.arraycopy(input, 0, benchmarkExpressions, 0, input.length);


        Expression[] temp = new Expression[input.length];
        m.mergeSort(input,temp);
        Arrays.stream(input).forEach(System.out::println);



        Arrays.sort(benchmarkExpressions);
        System.out.println(Arrays.toString(benchmarkExpressions));
    }

}
