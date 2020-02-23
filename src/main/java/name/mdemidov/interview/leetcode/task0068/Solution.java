package name.mdemidov.interview.leetcode.task0068;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 *
 * 68. Text Justification
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly
 * maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each
 * line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces
 * on a line do not divide evenly between words, the empty slots on the left will be assigned more
 * spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between
 * words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 *
 * Example 2:
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 *
 * Example 3:
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */
public class Solution {

    private static final Solution S = new Solution();

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int width = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (width > 0) {
                width++;
            }
            width = width + word.length();
            if (width > maxWidth) {
                putSpaces(sb, maxWidth);
                res.add(sb.toString());
                sb = new StringBuilder(word);
                width = word.length();
                if (i >= words.length - 1) {
                    while (sb.length() < maxWidth) {
                        sb.append(" ");
                    }
                    res.add(sb.toString());
                }
                continue;
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(word);
            if (i >= words.length - 1) {
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                res.add(sb.toString());
            }

        }
        return res;
    }

    private static void putSpaces(StringBuilder sb, int maxWidth) {
        int i = sb.indexOf(" ");
        if (i < 0) {
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
        }
        while (sb.length() < maxWidth) {
            while (sb.charAt(i) == ' ') {
                i++;
            }
            sb.insert(i++, ' ');
            i = sb.indexOf(" ", i);
            if (i < 0) {
                i = sb.indexOf(" ");
            }
        }
    }

    public static void main(String[] args) {
        String[] words1 = new String[]{
            "This", "is", "an", "example", "of", "text", "justification."
        };
        S.fullJustify(words1, 16).forEach(System.out::println);

        String[] words2 = new String[]{
            "What", "must", "be", "acknowledgment", "shall", "be"
        };
        S.fullJustify(words2, 16).forEach(System.out::println);

        String[] words3 = new String[]{
            "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
            "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        };
        S.fullJustify(words3, 20).forEach(System.out::println);

        String[] words4 = new String[]{
            "Listen", "to", "many,", "speak", "to", "a", "few."
        };
        S.fullJustify(words4, 6).forEach(System.out::println);
    }
}
