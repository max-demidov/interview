package name.mdemidov.interview.leetcode.task0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 *
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(
            new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private static int hash(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return Arrays.hashCode(count);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int key = hash(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<Integer, List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            int key = 1;
//            for (int i = 0; i < str.length(); i++) {
//                key += 31 * key * (17 + str.charAt(i));
//            }
//            map.putIfAbsent(key, new ArrayList<>());
//            map.get(key).add(str);
//        }
//        return new ArrayList<>(map.values());
//    }

}
