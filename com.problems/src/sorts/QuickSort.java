package sorts;

public class QuickSort {

    public static void quickSort(int[] array){
        quickSort(array,0,(array.length)-1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        int pivot = (left+right)/2;
        int index = partition(array,left,right,pivot);
        quickSort(array,left,index-1);
        quickSort(array,index,right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left<=right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left<=right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right){
        int temp;
        temp=array[left];
        array[left]=array[right];
        array[right]=temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,5,1,9,8,6};
        quickSort(input);
    }
}
