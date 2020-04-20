package name.mdemidov.interview.leetcode.task0067;

public class Solution {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(new Solution().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        String res = "";
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int l = Math.max(aa.length, bb.length);
        boolean add = false;
        for (int i = 1; i <= l; i++) {
            int sum = add ? 1 : 0;
            char aaa = (aa.length - i >= 0) ? aa[aa.length - i] : '0';
            char bbb = (bb.length - i >= 0) ? bb[bb.length - i] : '0';
            if (aaa == '1') {
                sum++;
            }
            if (bbb == '1') {
                sum++;
            }
            if (sum % 2 > 0) {
                res = "1" + res;
            } else {
                res = "0" + res;
            }
            add = sum > 1;
        }
        return add ? "1" + res : res;
    }

}
