package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Neha.Sony
 */

public class RomanNumberToInt {
        private Map<Character,Integer> valueMap = new HashMap();
        public int romanToInt(String s) {
            valueMap.put('I',1);
            valueMap.put('V',5);
            valueMap.put('X',10);
            valueMap.put('L',50);
            valueMap.put('C',100);
            valueMap.put('D',500);
            valueMap.put('M',1000);
            char[] array =s.toCharArray();
            int result =0;
            for(int i = 0;i<array.length;i++){
                if(array.length>i+1){
                    if(valueMap.get(array[i])>valueMap.get(array[i+1])){
                        if(array.length>i+2){
                            if(valueMap.get(array[i+1])<valueMap.get(array[i+2])){
                                result =valueMap.get(array[i+2])-valueMap.get(array[i+1]);
                            } result =valueMap.get(array[i+2])+valueMap.get(array[i+1]);
                        }
                        result=valueMap.get(array[i])+result;
                    }else{
                        if(array.length>i+2){
                            if(valueMap.get(array[i+1])<valueMap.get(array[i+2])){
                                result =valueMap.get(array[i+2])-valueMap.get(array[i+1]);
                            } result =valueMap.get(array[i+2])+valueMap.get(array[i+1]);
                        }
                        result=valueMap.get(array[i+1])-result;
                    }
                } i+=3;
        }
            return result;
    }

    public static void main(String[] args) {
        RomanNumberToInt romanNumberToInt = new RomanNumberToInt();
        System.out.println(romanNumberToInt.romanToInt("MCMXCIV"));
    }
}
