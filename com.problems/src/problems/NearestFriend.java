package problems;/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

** Problem **
Imagine you are building a friend locator app.
Given your current position identified on a bidimensional plane as (0,0) and a list of friend locations,
each identified by a (x,y) pair, return the k closest friends to your current location.

For simplicity, you can compute the distance between you and your friends using the Euclidean distance formula ( d = sqrt(x^2 +y^2) ).

Given a list of friend locations [[1,3], [-2,2]], K = 1
Output: [[-2,2]]

 */

class NearestFriend {

    //List to store all co-ordinates
    static ArrayList<List<Integer>> friends = new ArrayList<List<Integer>>();


    //Storing distance from each friend
    static Map<Double,List<List<Integer>>> distanceMap= new TreeMap<Double,List<List<Integer>>>();


    private static Double getDistance(List<Integer> cordinates){
        Double distance =0d;
        distance=Math.sqrt(Math.pow(cordinates.get(0), 2)+Math.pow(cordinates.get(1), 2));
        System.out.println(distance);
        return distance;
    }

    public static void main(String[] args) {

        friends.add(Arrays.asList(1,3));
        friends.add(Arrays.asList(-2,2));
        friends.add(Arrays.asList(4,2));
        friends.add(Arrays.asList(7,2));
        friends.add(Arrays.asList(1,2));
        Integer k=2;
        for ( List<Integer> list: friends) {
            Double distance = getDistance(list);
            if(distanceMap.get(distance)==null){
                distanceMap.put(distance,new LinkedList(list));
            }else{
                distanceMap.get(distance).add(list);
            }
        }
        while (k>0){
            k--;
            System.out.println();
            System.out.println(distanceMap.entrySet().iterator().next());
        }

    }
}