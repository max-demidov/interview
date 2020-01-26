package name.mdemidov.interview.leetcode.task1048;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/longest-string-chain/
 *
 * 1048. Longest String Chain
 *
 * Given a list of words, each word consists of English lowercase letters.
 *
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere
 * in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".
 *
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is
 * a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
 *
 * Return the longest possible length of a word chain with words chosen from the given list of
 * words.
 *
 * Example 1:
 *
 * Input: ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 *
 * Note:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of English lowercase letters.
 */
public class Solution {

    private static final Solution S = new Solution();
    private static Map<String, Integer> longestChain;

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        // System.out.println(Arrays.toString(words));
        int max = 1;
        longestChain = new HashMap<>();
        for (int i = 0; i < words.length - max; i++) {
            max = Math.max(max, longestStrChain(words, i));
        }
        return max;
    }

    private static int longestStrChain(String[] words, int index) {
        String word = words[index];
        if (longestChain.containsKey(word)) {
            return longestChain.get(word);
        }
        int max = 1;
        for (int i = index + 1; i < words.length; i++) {
            if (isPredecessor(word, words[i])) {
                max = Math.max(max, 1 + longestStrChain(words, i));
            }
        }
        // System.out.printf("word=%s, max=%d%n", words[index], max);
        longestChain.put(words[index], max);
        return max;
    }

    private static boolean isPredecessor(String predecessor, String word) {
        if (word.length() - predecessor.length() != 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        boolean isMismatchFound = false;
        while (i < word.length() && j < predecessor.length()) {
            if (word.charAt(i) != predecessor.charAt(j)) {
                if (isMismatchFound) {
                    return false;
                }
                isMismatchFound = true;
                i++;
                continue;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] tests = {
            {"a", "b", "ba", "bca", "bda", "bdca"},
            {"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh",
             "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx",
             "gru"},
            {"kxbvnw", "uqjszp", "pmukt", "aai", "aaicwm", "mhkzelhyek", "cjv", "v", "uqjjspzpp",
             "aaim", "uqjjszp", "uqjjspzppd", "uqjjspzp", "aaicm", "pukt", "pvmukt", "dgdb",
             "aaicwbm", "mhkelhyek", "jv"},
            {"kwigbkfeqp", "tpiufntqzo", "blmwegckaplqwjpo", "uiesdrhcbvbbk", "przuvuo",
             "kntmjgnqbxlwh", "glac", "uz", "qqhw", "gdtunmaw", "neymepxl", "eqtxh", "qz", "bek",
             "xgadqztq", "cicgtxs", "grakdthb", "kwigbkfeqop", "uqyqhjqwegizcx", "kewiygbkfejqop",
             "tufntz", "gulamac", "sluiobdm", "ujdyugagn", "fuyz", "eth", "vzxiobwgyhrdkh",
             "ikfjaivyvreql", "jimpyin", "cuotmvfqzizu", "tkopssxh", "gmwmzsowjf", "nel", "zo",
             "kntmmjgnqbxtlwh", "cyuicglbdtxwsu", "vjrenjwntklm", "uevrxuklobce", "tkaopssxh",
             "rwkedydnadd", "uqyqhjqdwegizcx", "ouethhse", "zcmmrtilpti", "tmfuxxyk", "honyw",
             "nyepl", "qqhqwix", "mjhg", "gdtwunmaw", "kigbkfeqp", "wnyhsm", "oeqatxhree",
             "qyqhjqweizcx", "xadqztq", "wqnyghsmt", "ndozeaylmetnpxlj", "przuvuhob",
             "wqnlyghnqsmtt", "tkossxh", "qyqhjqwix", "epwcjxytvt", "bexk", "ga", "em", "zojodbw",
             "gulmac", "cizocgw", "suibdm", "nvcyutywhus", "bwjofkuchx", "f", "pdtwv",
             "dzohajcodbw", "kuc", "tpawplvfzlx", "mg", "re", "oh", "wciqob", "el", "wciqo",
             "mftmgv", "grakkdthtbd", "cnbnyvuhmrj", "odqphbhkf", "oeqatxhre", "sqzrlhs",
             "bwsjofvkuptchx", "xdqztq", "tmv", "kewigbkfejqop", "faepomn", "bdwwnalubrvxtdgu",
             "cotmfqziz", "lvzl", "dmqz", "hdmqz", "gdigs", "ujdyugag", "mepjqbuvdku", "g",
             "kigbkeqp", "oegqataxhree", "zscinzobcgtwdwhn", "fuaepwobimn", "qf", "cusotmvfqziknzu",
             "qvroffuk", "rweydnadd", "zoow", "meqcfzkbnrb", "tpaplvzlx", "zscinzocgwdwhn",
             "zcmmrtilpt", "ndeaymenpxlj", "jimpn", "wofkuchx", "tkaopsssxh", "vodwqphbhkfx",
             "faepwoimn", "gzenkasrciui", "nyhm", "tpufntqzo", "ovqeyvxfdll", "tufntzo", "gmyrmf",
             "vxobwgrdkh", "faepwobimn", "przujvuhobk", "vzxobwgyrdkh", "ksszdumgko",
             "kewiylgbkfejqop", "rey", "vo", "qqfe", "moyddffrwwyzk", "qzwsbnuejvsi",
             "vodwqpzhbhjkfx", "r", "vttpoelti", "sqzrlehhs", "tpiuftntqzo", "qfe", "qyvsrofgnfuk",
             "evxuklce", "wiqo", "prpzuujvuaxhkobk", "gy", "vnjxkjvmz", "qroffuk", "qqhwi",
             "przuvuhobk", "mfttmgvj", "moydfrwzk", "jibmpuyin", "pwcytvt", "eqtxhre", "gcdtwunmaw",
             "wfkucx", "ryedhy", "vttpolti", "qyqhqwix", "kutkavldvvqvp", "el", "tmfuxxyku",
             "tplvzlx", "gdtu", "z", "ksg", "xmgadqzptq", "qcqfre", "zcmmrtiklpti", "hobxltexk",
             "vburq", "funyz", "kc", "vjrenjwntklqm", "wqnlyghnqsmt", "sibdm", "vodwqpzhbhkfx",
             "zsnv", "pouegzfyk", "arci", "vzxobwgyhrdkh", "fetoesaot", "riyedhy", "cyuicgtxsu",
             "gdtua", "gchdtwgwunmaw", "cuotmvfqziz", "obltexk", "epwcytvt", "scinzocgw", "ptwv",
             "jimpuyin", "uevrxukloce", "tkqaopsssxh", "pdtwdv", "fetsaot", "cyuicgldtxsu",
             "przujvuaxhkobk", "wciqoxb", "gdtuna", "lvzlx", "ytpawcplvfzlx", "uyugag",
             "ksszdumugiko", "bm", "pgdmigs", "grakdthtbd", "uyz", "zscinzobcgwdwhn", "oeqataxhree",
             "qzsbnuvs", "gznkarciui", "zoodw", "jimpin", "tqksugh", "zuvo", "tmgv", "gdmigs",
             "sluibdm", "nvcxyzwyutywhus", "bwsjofkuchx", "fetsat", "kgbeqp", "neymenpxlj",
             "vzxobwgrdkh", "tpawcplvfzlx", "qbzwsbnuejvsi", "przuvuho", "wqnlyguhnqsmtt",
             "ujhadylujgaazgsn", "axuelrnnnwhg", "qbzwsbnuejvsmoi", "qzsbnuvsi", "yugag",
             "bwsjofvkupchx", "mqz", "gchdtwunmaw", "kntmmjgnqbxlwh", "xfpt", "vvburq", "moydfrwk",
             "qksgh", "faepoimn", "odwqphbhkfx", "ryey", "gchdtwwunmaw", "uiesdrhcvbbk",
             "qyqhjqwicx", "yilxbltwwxh", "jrenjwntkm", "gzenkarciui", "moyddffrhwwyezk",
             "tqksugvhr", "oveyvxfl", "agmyrmf", "scinzocgwdn", "neymenpxl", "gonpxzngjv",
             "rwkeydnadd", "zohjodbw", "bdwwnalubvxtdgu", "jrenjwntk", "ovqheyvxubfdtll",
             "qcqfqrezof", "znkarcii", "b", "qzsnuvs", "ndzeaylmenpxlj", "tossxh", "fetsa",
             "przujvuxhkobk", "ovqeyvxubfdll", "tpufntzo", "cuicgtxs", "mv", "vbur",
             "moyddffrhwwyzk", "yilxcbltwwxh", "eqtxhe", "zow", "qbzwsbnuejvsoi", "nvczwyutywhus",
             "cyquicglbdtxwsu", "evxukce", "axuelrnnwhg", "aci", "ouemthhqse", "wfkuchx",
             "bwsjofvkmuptchx", "mfjhg", "bwsjofvkuchx", "qffu", "qyqhjqwegizcx", "rzuvuo", "uvo",
             "qh", "qvsrofgfuk", "neymepl", "mepjqybuvdku", "sqzrlehs", "cnbnyvumrj", "qcqfqrezoif",
             "gyrm", "przujvuhkobk", "cuotmvfqzinzu", "gym", "ujdylujgaagn", "thdmmqz", "honw",
             "odwqphbhkf", "ksszgko", "qbzwsbnuejvsmvoi", "m", "gtu", "qyvsrofgfuk",
             "uqqyqhjqdwegizcx", "obtexk", "hobltexk", "ftmgv", "bwsjofvkmuptchxy", "taynfxo",
             "tqksugvhrc", "jibmpduyin", "vxue", "zuvuo", "gonpxzngv", "gmpwamzsowjf", "rwednadd",
             "zv", "tosh", "pqdtwdv", "zcmmrtsiklpti", "tkqaopesssxh", "ovqeyvxbfdll", "gac",
             "gsqzrlehhs", "znv", "cuotmvfqziknzu", "ryedy", "vnjoxkjvmz", "pouegnzfyk",
             "evrxuklce", "ujdyujgagn", "tmfnuxxyku", "semj", "xmgadvqzptq", "cnnyvmrj",
             "gonpxzvngjv", "meqczkbnrb", "bwofkuchx", "fuvnyz", "znarci", "moydffrwzk",
             "kwigbkfejqop", "wqnyghnsmt", "uiesdrehcbvobbk", "qcqfreo", "zohajodbw",
             "nvcxyzwyutywhuhs", "scinzocgwdwn", "ksyszdumugiko", "qfu", "mjg", "zsnuvs", "eqth",
             "ccgtxs", "pgdmidtgs", "rwednad", "lel", "cusotmvfqzwiknzu", "znkarciui", "o",
             "qzsbnuevsi", "veodwqpzhbhjkfx", "jrenjwntklm", "gmwamzsowjf", "ndeymenpxlj",
             "moydffrwwzk", "nvczyutywhus", "dzohajodbw", "ujadylujgaazgsn", "nvcytywhus",
             "qcqfrezo", "mfttmgv", "tqksugvh", "qksg", "njxkjvmz", "udyugag", "qffuk", "ksszdugko",
             "wkuc", "tmfxxyk", "qqh", "sbdm", "rwedna", "ovqheyvxubsfdtll", "ndzeaymenpxlj",
             "neyepl", "qf", "xgadqzptq", "redna", "pougzfyk", "zarci", "mftbtmgvj", "taplvzlx",
             "uiesdrhcbvobbk", "ovqeyvxfdl", "qcqfrezof", "qvrofgfuk", "scizocgw", "mftbtmgvdj",
             "rsgwmsted", "ovqheyvxubfdll", "oveyvxfdl", "m", "wi", "znkarci", "ikfjaivyvrql",
             "pgdmidgs", "btexk", "cuotmfqziz", "xdqzq", "jimp", "qqhqwi", "lvz", "ilojawyersju",
             "wnyhm", "gsqzrlenhhs", "bu", "wkucx", "bdm", "lsel", "tpawplvzlx", "ai",
             "kntmmjognqbxtlwh", "hkonyw", "vxuce", "zsnvs", "qyqhjqweicx", "nyel", "cyuicgtxs",
             "qzsbnuejvsi", "ujadylujgaagsn", "thdmqz", "ilojawyersu", "uevirxuklobce", "qrffuk",
             "zoodbw", "sem", "cyuicgldtxwsu", "wnyhsmt", "prpzujvuaxhkobk", "uesdrhcvbbk",
             "vhvburq", "ndzeaylmetnpxlj", "ksszdgko", "scinzocgwd", "cyuicgltxsu", "ptw", "mplaxm",
             "scinzocgwdwhn", "ytpawcplvifzlx", "evxuce", "bur", "kigbeqp", "ksszdumugko",
             "cnnyvumrj", "toh", "kewiylgbkfejqfop", "gulac", "pugzfyk", "nvcyzwyutywhus",
             "ouemthhse", "wqnyghnqsmt", "b", "ujdylujgagn", "tlvzlx", "pgidmidtgs", "eqatxhre",
             "gmyrm", "dqzq", "oveyvxl", "vttpoeltci", "gk", "wqnyhsmt", "zcmmrtsitklpti",
             "iaxuelrnnnwhg", "gdtunma", "ujadylujgaagn", "tqksgh", "moydffrwwyzk", "mfftbtmgvdj",
             "wio", "fetosaot", "grakdthtb", "nxmrvm", "evrxukloce", "ikfjaivyrql", "tosxh",
             "grakkbdthtbd", "epwcxytvt", "blmwegckaplwjpo", "qcqfe"}
        };
        Stream.of(tests).forEach(t -> System.out.println(S.longestStrChain(t)));
    }
}
