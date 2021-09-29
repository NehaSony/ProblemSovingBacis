package leetcode;

import java.util.Arrays;

public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        char[] numArray = String.valueOf(n).toCharArray();
        char[] newArray = new char[numArray.length];
        if (numArray.length==1)
            return -1;
        for(int i=0;i<numArray.length;i++){
            newArray[i] = numArray[numArray.length-i-1];
        }
        if (Integer.parseInt(String.valueOf(newArray))>n)
            return Integer.parseInt(String.valueOf(newArray));
        for(int j=0;j<numArray.length;j++) {
            newArray = new char[numArray.length];
            for (int i = 0; i < numArray.length; i++) {
                newArray[i]= i+1<numArray.length?numArray[i+1]:numArray[0];
            }
            if (Integer.parseInt(String.valueOf(newArray))>n)
                return Integer.parseInt(String.valueOf(newArray));
            numArray=newArray;
        }
        return -1;

    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        System.out.println(nextGreaterElement.nextGreaterElement(101));
    }
}
