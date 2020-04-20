package name.mdemidov.interview.leetcode.task0013;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int res = 0;

        if (s.contains("IV")) {
            res += 4;
            s = s.replace("IV", "");
        }
        if (s.contains("IX")) {
            res += 9;
            s = s.replace("IX", "");
        }
        if (s.contains("XL")) {
            res += 40;
            s = s.replace("XL", "");
        }
        if (s.contains("XC")) {
            res += 90;
            s = s.replace("XC", "");
        }
        if (s.contains("CD")) {
            res += 400;
            s = s.replace("CD", "");
        }
        if (s.contains("CM")) {
            res += 900;
            s = s.replace("CM", "");
        }

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'I') {
                res++;
            } else if (c == 'V') {
                res += 5;
            } else if (c == 'X') {
                res += 10;
            } else if (c == 'L') {
                res += 50;
            } else if (c == 'C') {
                res += 100;
            } else if (c == 'D') {
                res += 500;
            } else if (c == 'M') {
                res += 1000;
            }
        }

        return res;
    }

}
