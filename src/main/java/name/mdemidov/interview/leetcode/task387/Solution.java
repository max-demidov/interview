package name.mdemidov.interview.leetcode.task387;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("leetcode"));
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
        System.out.println(new Solution().firstUniqChar("loveevol"));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.putIfAbsent(c, 0);
            count.put(c, count.get(c) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) < 2) {
                return i;
            }
        }
        return -1;
    }

//    public int firstUniqChar(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            boolean isUnique = true;
//            for (int j = 0; j < s.length(); j++) {
//                if (i != j && s.charAt(i) == s.charAt(j)) {
//                    isUnique = false;
//                    break;
//                }
//            }
//            if (isUnique) {
//                return i;
//            }
//        }
//        return -1;
//    }

}
