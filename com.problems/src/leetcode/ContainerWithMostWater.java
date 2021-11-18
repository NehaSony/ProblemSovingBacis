package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Neha.Sony
 */

/*Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
Notice that you may not slant the container.*/

public class ContainerWithMostWater {
        public int maxArea(int[] height) {
            List<Integer> areaList = new ArrayList();
            int len = height.length;
            if(len==2){
                return this.getMin(height[0], height[1]) ;
            }
            for(int j = len-1;j>2;j--) {
                for (int i = 0; i < len && i<j; i++) {
                    areaList.add(this.getMin(height[i], height[j]) * (j-i));
                }
            }
            Collections.sort(areaList,Comparator.reverseOrder());
            return areaList.get(0);
        }

        private int getMin(int a,int b){
            if(a<b)
                return a;
            return b;
        }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {1,2,1};
        System.out.println(containerWithMostWater.maxArea(height));
    }
}
