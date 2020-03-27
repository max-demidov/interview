package name.mdemidov.interview.leetcode.task0127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * 127. Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int count = 0;
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return count;
                }

                List<String> toRemove = new ArrayList<>();
                for (String w : dict) {
                    if (isOneCharDiff(w, word)) {
                        queue.offer(w);
                        toRemove.add(w);
                    }
                }
                dict.removeAll(toRemove);
            }
        }

        return 0;
    }

    private static boolean isOneCharDiff(String a, String b) {
        int num = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
            }
            if (num > 1) {
                return false;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(
            S.ladderLength("hit", "cog",
                           Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))); // 5
        System.out.println(
            S.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"))); // 0
        System.out.println(S.ladderLength("a", "c", Arrays.asList("a", "b", "c"))); // 2
    }
}
