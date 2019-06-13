package name.mdemidov.interview.interview20190611;

import java.util.ArrayList;
import java.util.List;

/**
 * ["abc", "abcdb", "gggh", "klsrtabcabc", "118*90", "ggggggggggggggggggggggggggggggggg"]
 * return words which contains all letters from [a,b,b,c]
 * -> "abcdb","klsrtabcabc"
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().getWordsContainingAllLetters(
            new String[]{"abc", "abcdb", "gggh", "klsrtabcabc", "118*90", "ggggggggggggggggggggggggggggggggg"},
            new char[]{'a', 'b', 'b', 'c'}));
    }

    private List<String> getWordsContainingAllLetters(String[] words, char[] chars) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean containsAll = true;
            String word = words[i];
            for (char c : chars) {
                if (!word.contains(String.valueOf(c))) {
                    containsAll = false;
                    break;
                }
                int index = word.indexOf(String.valueOf(c));
                // remove first char met in the word
                word = word.substring(0, index) + word.substring(index + 1);
            }
            if (containsAll) {
                result.add(words[i]);
            }
        }
        return result;
    }
}
