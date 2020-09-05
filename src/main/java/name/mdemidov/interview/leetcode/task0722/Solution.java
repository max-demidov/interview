package name.mdemidov.interview.leetcode.task0722;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-comments/
 * <p>
 * 722. Remove Comments
 * <p>
 * Given a C++ program, remove comments from it. The program source is an array where source[i] is
 * the i-th line of the source code. This represents the result of splitting the original source
 * code string by the newline character \n.
 * <p>
 * In C++, there are two types of comments, line comments, and block comments.
 * <p>
 * The string // denotes a line comment, which represents that it and rest of the characters to the
 * right of it in the same line should be ignored.
 * <p>
 * Note:
 * <p>
 * <li>The length of source is in the range [1, 100].
 * <li>The length of source[i] is in the range [0, 80].
 * <li>Every open block comment is eventually closed.
 * <li>There are no single-quote, double-quote, or control characters in the source code.
 */
public class Solution {

  private static final Solution S = new Solution();

  public List<String> removeComments(String[] source) {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean isOpen = false;
    for (String line : source) {
      for (int i = 0; i < line.length(); i++) {
        if (isOpen) {
          if (i < line.length() - 1 && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
            i++;
            isOpen = false;
          }
        } else {
          if (i < line.length() - 1 && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
            i++;
            isOpen = true;
          } else if (i < line.length() - 1 && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
            break;
          } else {
            sb.append(line.charAt(i));
          }
        }
      }
      if (!isOpen && sb.length() > 0) {
        res.add(sb.toString());
        sb = new StringBuilder();
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String[] s1 = new String[]{
        "/*Test program */",
        "int main()",
        "{ ",
        "  // variable declaration ",
        "int a, b, c;",
        "/* This is a test",
        "   multiline  ",
        "   comment for ",
        "   testing */",
        "a = b + c;",
        "}"
    };
    // [int main(), { ,   , int a, b, c;, a = b + c;, }]
    System.out.println(S.removeComments(s1));

    String[] s2 = new String[]{
        "a/*comment",
        "line",
        "more_comment*/b"
    };
    // [ab]
    System.out.println(S.removeComments(s2));

    String[] s3 = new String[]{
        "main() {",
        "/* here is commments",
        "  // still comments */",
        "   double s = 33;",
        "   cout << s;",
        "}"
    };
    // ["main() {","   double s = 33;","   cout << s;","}"]
    System.out.println(S.removeComments(s3));

    String[] s4 = new String[]{
        "void func(int k) {",
        "// this function does nothing /*",
        "   k = k*2/4;",
        "   k = k/2;*/",
        "}"
    };
    // ["void func(int k) {","   k = k*2/4;","   k = k/2;*/","}"]
    System.out.println(S.removeComments(s4));

    String[] s5 = new String[]{
        "main() {",
        "  Node* p;",
        "  /* declare a Node",
        "  /*float f = 2.0",
        "   p->val = f;",
        "   /**/",
        "   p->val = 1;",
        "   //*/ cout << success;*/",
        "}",
        " "
    };
    // ["main() {","  Node* p;","  ","   p->val = 1;","   ","}"," "]
    System.out.println(S.removeComments(s5));
  }
}
