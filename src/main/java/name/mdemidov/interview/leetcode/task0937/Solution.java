package name.mdemidov.interview.leetcode.task0937;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 *
 * 937. Reorder Data in Log Files
 *
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * - Each word after the identifier will consist only of lowercase letters, or;
 * - Each word after the identifier will consist only of digits.
 *
 * We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used
 * in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 * Constraints:
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class Solution {

    private static final Solution S = new Solution();

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (String log : logs) {
            int startIndex = log.indexOf(' ') + 1;
            char startChar = log.charAt(startIndex);
            if (startChar >= '0' && startChar <= '9') {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        letterLogs.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                int diff = ending(o1).compareTo(ending(o2));
                return diff == 0 ? beginning(o1).compareTo(beginning(o2)) : diff;
            }

            private String ending(String s) {
                return s.substring(s.indexOf(' ') + 1);
            }

            private String beginning(String s) {
                return s.substring(0, s.indexOf(' '));
            }
        });
        String[] res = new String[logs.length];
        int letterLogIndex = 0;
        for (int i = 0; i < logs.length; i++) {
            if (letterLogIndex < letterLogs.size()) {
                res[i] = letterLogs.get(letterLogIndex);
                letterLogIndex++;
            } else {
                res[i] = digitLogs.get(i - letterLogIndex);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] logs1 = {
            "dig1 8 1 5 1",
            "let1 art can",
            "dig2 3 6",
            "let2 own kit dig",
            "let3 art zero"
        };
        System.out.println(Arrays.toString(S.reorderLogFiles(logs1)));
        String[] logs2 = {
            "a1 9 2 3 1",
            "g1 act car",
            "zo4 4 7",
            "ab1 off key dog",
            "a8 act zoo",
            "a2 act car"
        };
        System.out.println(Arrays.toString(S.reorderLogFiles(logs2)));
    }
}
