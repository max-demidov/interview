package name.mdemidov.interview.leetcode.task0771;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class Solution {

    public int numJewelsInStones(String J, String S) {
        int n = 0;
        for (char c : S.toCharArray()) {
            if (J.contains("" + c)) {
                n++;
            }
        }
        return n;

    }
}
