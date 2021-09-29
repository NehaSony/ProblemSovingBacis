package leetcode;

/**
 * @author Neha Sony
 */


/*
*
There is a broken calculator that has the integer startValue on its display initially. In on operation you can:

multiply the number on the display by 2, or
subtract 1 from the number on the display.
Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.



Example 1:

Input: startValue = 2, target = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
Example 2:

Input: startValue = 5, target = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
Example 3:

Input: startValue = 3, target = 10
Output: 3
Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
Example 4:

Input: startValue = 1024, target = 1
Output: 1023
Explanation: Use decrement operations 1023 times.
*
* */
public class BrokenCalculator {
    int counter = 0;

    public static void main(String[] args) {
        BrokenCalculator brokenCalculator = new BrokenCalculator();
        System.out.println(brokenCalculator.brokenCalc(1, 1000000000));
    }

    public int brokenCalc(int startValue, int target) {
        if (startValue > target)
            return (startValue - target);
        if (startValue==target)
            return 0;
        this.multiplyByTwo(startValue, target);
        return counter;
    }

    private void multiplyByTwo(int startValue, int target) {
        while(startValue<target) {
            counter++;
            if (startValue%2==0) {
                target = target / 2;
            } else {
                target--;
            }
        }
    }



}
