package leetcode;

import java.util.Stack;

/**
 * @author Neha.Sony
 */

class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("(("));

    }

    public boolean isValid(String s) {
        char c[] = s.toCharArray();
        int size = s.length();
        if(size%2==1) return false;
        Stack<Character> operators = new Stack<Character>();
        int i =0;
        while(i<size){
            switch(c[i]){
                case '(':
                case '{':
                case '[':if(i==size)return false;
                    operators.push(c[i]);
                    i++;
                    break;
                case ')':if(operators.pop().equals(Character.valueOf('('))){
                    i++;
                    break;
                } else{
                    return false;
                }
                case '}':if(operators.pop().equals(Character.valueOf('{'))){
                    i++;
                    break;
                } else{
                    return false;
                }
                case ']': if(operators.pop().equals(Character.valueOf('['))){
                    i++;
                    break;
                } else{
                    return false;
                }
            }
        }
        return true;

    }
}