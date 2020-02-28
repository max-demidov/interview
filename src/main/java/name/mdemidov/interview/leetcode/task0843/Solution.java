package name.mdemidov.interview.leetcode.task0843;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/guess-the-word/
 *
 * 843. Guess the Word
 *
 * This problem is an interactive problem new to the LeetCode platform.
 *
 * We are given a word list of unique words, each word is 6 letters long, and one word in this list
 * is chosen as secret.
 *
 * You may call master.guess(word) to guess a word.  The guessed word should have type string and
 * must be from the original list with 6 lowercase letters.
 *
 * This function returns an integer type, representing the number of exact matches (value and
 * position) of your guess to the secret word.  Also, if your guess is not in the given wordlist,
 * it will return -1 instead.
 *
 * For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if
 * you have made 10 or less calls to master.guess and at least one of these guesses was the secret,
 * you pass the testcase.
 *
 * Besides the example test case below, there will be 5 additional test cases, each with 100 words
 * in the word list.  The letters of each word in those testcases were chosen independently at
 * random from 'a' to 'z', such that every word in the given word lists is unique.
 *
 * Example 1:
 * Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
 *
 * Explanation:
 *
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
 * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 *
 * We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
 *
 * Note:  Any solutions that attempt to circumvent the judge will result in disqualification.
 */
public class Solution {

    private static final Solution S = new Solution();

    interface Master {

        int guess(String word);
    }

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = new LinkedList<>(Arrays.asList(wordlist));
        for (int i = 0; i < 10; i++) {
            int r = new Random().nextInt(words.size());
            String guess = words.get(r);
            int matches = master.guess(guess);
            if (matches == 6) {
                return;
            }
            words.removeIf(w -> countMatches(w, guess) != matches);
        }
    }

    private static int countMatches(String s1, String s2) {
        int matches = 0;
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        S.findSecretWord(new String[]{"acckzz", "ccbazz", "eiowzz", "abcczz"}, word -> 6);
    }
}
