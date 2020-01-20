package name.mdemidov.interview.leetcode.task0767;

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
        int count[] = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                maxIndex = i;
            }
        }

        if (max > (S.length() + 1) / 2) {
            return "";
        }

        char[] seq = new char[S.length()];
        int i = 0;
        for (int j = 0; j < count.length; j++) {
            int k = (maxIndex + j) % count.length;
            while (count[k] > 0) {
                if (i >= seq.length) {
                    i = 1;
                }
                seq[i] = (char) ('a' + k);
                i += 2;
                count[k]--;
            }
        }
        return String.valueOf(seq);
    }

    public static void main(String[] args) {
        System.out.println(S.reorganizeString("aabcddd"));
        System.out.println(S.reorganizeString("ccaaaab"));
        System.out.println(S.reorganizeString("vvvlo"));
        System.out.println(S.reorganizeString("abbabba"));
        System.out.println(S.reorganizeString("aaba"));
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
