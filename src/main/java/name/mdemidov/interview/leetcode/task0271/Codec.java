package name.mdemidov.interview.leetcode.task0271;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/encode-and-decode-strings/
 *
 * 271. Encode and Decode Strings
 *
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent
 * over the network and is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *
 * string encode(vector<string> strs) {
 * // ... your code
 * return encoded_string;
 * }
 *
 * Machine 2 (receiver) has the function:
 *
 * vector<string> decode(string s) {
 * //... your code
 * return strs;
 * }
 *
 * So Machine 1 does:
 *
 * string encoded_string = encode(strs);
 *
 * and Machine 2 does:
 *
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 *
 * Note:
 *
 * The string may contain any possible characters out of 256 valid ascii characters.
 * Your algorithm should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states.
 * Your encode and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods.
 * You should implement your own encode/decode algorithm.
 */
public class Codec {

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode(Arrays.asList("abc", "xyz"))));
        System.out.println(codec.decode(codec.encode(Arrays.asList("", "", ""))));
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        return strs.isEmpty() ? null : String.join("\n", strs);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\n') {
                res.add(s.substring(last, i));
                last = i + 1;
            }
        }
        res.add(s.substring(last));
        return res;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));