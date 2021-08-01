package hackerrank;
/*
* An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense Ranking, so its leaderboard works like this:

The player with the highest score is ranked number  on the leaderboard.
Players who have equal scores receive the same ranking number 1, and the next player(s) receive the immediately following ranking number.
*
*
*Function Description

Complete the climbingLeaderboard function in the editor below.

climbingLeaderboard has the following parameter(s):

int ranked[n]: the leaderboard scores
int player[m]: the player's scores
Returns

int[m]: the player's rank after each new score
* */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class climbingLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        Set<Integer> sortedRankedSet = new TreeSet();
        List<Integer> returnList = new LinkedList();
        ranked.forEach(e->{
            sortedRankedSet.add(e);
        });
        player.forEach(e->{
            sortedRankedSet.add(e);
            returnList.add(getIndex(sortedRankedSet,e));
        });
        System.out.println(returnList);
        return returnList;
    }

    public static int getIndex(Set<? extends Object> set, Object value) {
        int result = set.size();
        for (Object entry:set) {
            if (entry.equals(value)) return result;
            result--;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/Z002X5H/Documents/Others/test.txt"));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
