package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class Finonacci {
    public static Integer fib(Integer n, Map<Integer,Integer> memo) {
        if (n <= 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else if (memo.containsKey(n)){
            return memo.get(n);
        } else {
            Integer fibOfN = fib(n-1, memo) + fib(n-2, memo);
            memo.put(n,fibOfN);
            return fibOfN;
        }
    }
    public static void main(String[] args) {
        Finonacci serise = new Finonacci();
        Integer result = serise.fib(9,new HashMap<>());
        System.out.println(result);
    }
}

