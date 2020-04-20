package name.mdemidov.interview.leetcode.task0010;

public class Solution {

    public static void main(String[] args) {
        System.out.println("Expected false, actual " + new Solution().isMatch("aa", "a"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("aa", "a*"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("ab", ".*"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("aab", "c*a*b"));
        System.out.println("Expected false, actual " + new Solution().isMatch("mississippi", "mis*is*p*."));
        System.out.println("Expected  true, actual " + new Solution().isMatch("mississippi", "m.s*is*ip*."));
        System.out.println("Expected  true, actual " + new Solution().isMatch("abcd", ".*cd"));
        System.out.println("Expected false, actual " + new Solution().isMatch("abcd", ".*c"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("aaa", "ab*a*c*a"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("a", "ab*"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("abbbcd", "ab*bbbcd"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("", "c*c*"));
        System.out.println("Expected false, actual " + new Solution().isMatch("aaa", "aaaa"));
        System.out.println("Expected false, actual " + new Solution().isMatch("acaabbaccbbacaabbb", "a*.*b*.*a*aa*a*"));
        System.out.println("Expected false, actual " + new Solution().isMatch("b", "b*aa*"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("abbabaaaaaaacaa", "a*.*b.a.*c*b*a*c*"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("ca", ".*c*"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("ab", ".*.."));
        System.out
            .println("Expected  true, actual " + new Solution().isMatch("bcbabcaacacbcabac", "a*c*a*b*.*aa*c*a*a*"));
        System.out.println("Expected  true, actual " + new Solution().isMatch("c", "c*a*"));
    }

    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     *
     * @param s - an input string
     * @param p - a pattern
     * @return result
     */
    public boolean isMatch(String s, String p) {
//        System.out.println("s=" + s + " p=" + p);
        if (s.equals(p)) {
            return true;
        }
        if (p.isEmpty()) {
            return false;
        }
        if (s.isEmpty()) {
            if (p.length() > 1 && p.charAt(1) == '*') {
                if (p.length() <= 2) {
                    return true;
                } else {
                    return isMatch(s, p.substring(2));
                }
            } else {
                return false;
            }
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (p.charAt(0) == '.') {
                if (p.length() == 2) {
                    return true;
                }
                if (s.length() == 1 && isMatch("", p.substring(2))) {
                    return true;
                }
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                if (isMatch(s.substring(1), p) || isMatch(s.substring(1), p.substring(2))) {
                    return true;
                }
                return false;
            }
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            if (p.charAt(0) == s.charAt(0)) {
                if (s.length() > 1) {
                    return isMatch(s.substring(1), p);
                } else {
                    if (p.length() == 2) {
                        return true;
                    }
                    return isMatch("", p.substring(2));
                }
            } else {
                return isMatch(s, p.substring(2));
            }
        }
        if (p.charAt(0) != s.charAt(0)) {
            if (p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
        return isMatch(s.length() > 1 ? s.substring(1) : "", p.length() > 1 ? p.substring(1) : "");
    }
}
