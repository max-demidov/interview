package name.mdemidov.interview.leetcode.task0211;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 *
 * <p>211. Design Add and Search Words Data Structure
 *
 * <p>Design a data structure that supports adding new words and finding if a string matches any
 * previously added string.
 *
 * <p>Implement the WordDictionary class:
 *
 * <ul>
 *   <li>WordDictionary() Initializes the object.
 *   <li>void addWord(word) Adds word to the data structure, it can be matched later.
 *   <li>bool search(word) Returns true if there is any string in the data structure that matches
 *       word or false otherwise. word may contain dots '.' where dots can be matched with any
 *       letter.
 * </ul>
 *
 * Example:
 *
 * <p>Input ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 *
 * <p>Output [null,null,null,null,false,true,true,true]
 *
 * <p>Explanation
 *
 * <pre>
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * </pre>
 *
 * <p>Constraints:
 *
 * <ul>
 *   <li>1 <= word.length <= 500
 *   <li>word in addWord consists lower-case English letters.
 *   <li>word in search consist of '.' or lower-case English letters.
 *   <li>At most 50000 calls will be made to addWord and search.
 * </ul>
 */
public class WordDictionary {
  private TrieNode root;

  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new TrieNode();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      node.children.putIfAbsent(c, new TrieNode());
      node = node.children.get(c);
    }
    node.word = true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   */
  public boolean search(String word) {
    return search(word, root);
  }

  private boolean search(String word, TrieNode node) {
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.children.containsKey(c)) {
        node = node.children.get(c);
      } else {
        if (c == '.') {
          for (TrieNode child : node.children.values()) {
            if (search(word.substring(i + 1), child)) {
              return true;
            }
          }
        }
        return false;
      }
    }
    return node.word;
  }

  public static void main(String[] args) {
    WordDictionary wd = new WordDictionary();
    wd.addWord("bad");
    wd.addWord("dad");
    wd.addWord("mad");
    System.out.println(wd.search("pad")); // false
    System.out.println(wd.search("bad")); // true
    System.out.println(wd.search(".ad")); // true
    System.out.println(wd.search("b..")); // true
  }

  private class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean word;
  }
}
