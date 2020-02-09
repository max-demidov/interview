package name.mdemidov.interview.leetcode.task0551;

/**
 * https://leetcode.com/problems/student-attendance-record-i/
 *
 * 551. Student Attendance Record I
 *
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain
 * more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 *
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean checkRecord(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                if (countL > 1) {
                    return false;
                }
                countL++;
            } else {
                countL = 0;
            }
            if (s.charAt(i) == 'A') {
                if (countA > 0) {
                    return false;
                }
                countA++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(S.checkRecord("PPALLP")); // true
        System.out.println(S.checkRecord("PPALLL")); // false
    }
}
