package name.mdemidov.interview.leetcode.task1153;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/string-transforms-into-another-string/
 *
 * 1153. String Transforms Into Another String
 *
 * Given two strings str1 and str2 of the same length, determine whether you can transform str1
 * into str2 by doing zero or more conversions.
 *
 * In one conversion you can convert all occurrences of one character in str1 to any other
 * lowercase English character.
 *
 * Return true if and only if you can transform str1 into str2.
 *
 * Example 1:
 *
 * Input: str1 = "aabcc", str2 = "ccdee"
 * Output: true
 * Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of
 * conversions matter.
 *
 * Example 2:
 *
 * Input: str1 = "leetcode", str2 = "codeleet"
 * Output: false
 * Explanation: There is no way to transform str1 to str2.
 *
 *
 * Note:
 *
 * 1 <= str1.length == str2.length <= 10^4
 * Both str1 and str2 contain only lowercase English letters.
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (map.getOrDefault(c1, c2) != c2) {
                return false;
            }
            map.put(c1, c2);
        }
        //System.out.println(map);
        //return map.values().stream().distinct().count() < 26;
        return new HashSet<>(map.values()).size() < 26;
    }

    public static void main(String[] args) {
        System.out.println(S.canConvert("aabcc", "ccdee")); // true
        System.out.println(S.canConvert("leetcode", "codeleet")); // false
        System.out.println(
            S.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza")); // false
        System.out.println(
            S.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyzq")); // true
    }
}
