package name.mdemidov.interview.leetcode.task0767;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/reorganize-string/
 *
 * 767. Reorganize String
 *
 * Given a string S, check if the letters can be rearranged
 * so that two characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * Example 1:
 *
 * Input: S = "aab"
 * Output: "aba"
 *
 * Example 2:
 *
 * Input: S = "aaab"
 * Output: ""
 * Note:
 *
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class Solution {

    private static final Solution S = new Solution();

    public String reorganizeString(String S) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        frequency = reverseSortByValue(frequency);
        //System.out.println(frequency);

        StringBuilder sb = new StringBuilder();
        char last = 0;
        while (!frequency.isEmpty()) {
            for (char c : frequency.keySet()) {
                if (last == c) {
                    if (frequency.size() == 1) {
                        return "";
                    }
                    continue;
                }
                sb.append(c);
                frequency.put(c, frequency.get(c) - 1);
                if (last > 0 && frequency.getOrDefault(last, 0) > 0) {
                    last = c;
                    break;
                }
                last = c;
            }
            frequency.entrySet().removeIf(e -> e.getValue() < 1);
            frequency = reverseSortByValue(frequency);
            //System.out.println(frequency);
        }
        return sb.toString();
    }

    private static Map<Character, Integer> reverseSortByValue(Map<Character, Integer> input) {
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(input.entrySet());
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        Map<Character, Integer> output = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            output.put(entry.getKey(), entry.getValue());
        }
        return output;
    }

    public static void main(String[] args) {
//        System.out.println(S.reorganizeString("aabcddd"));
//        System.out.println(S.reorganizeString("ccaaaab"));
//        System.out.println(S.reorganizeString("vvvlo"));
//        System.out.println(S.reorganizeString("abbabba"));
//        System.out.println(S.reorganizeString("aaba"));
        String s = "tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqke"
                   + "mtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonn"
                   + "szmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobm"
                   + "hwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxe"
                   + "bgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfy"
                   + "klvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupn"
                   + "ukayjghpusewdwrbkhvjnveuiionefmnfxao";
        System.out.println(S.reorganizeString(s));
    }
}
