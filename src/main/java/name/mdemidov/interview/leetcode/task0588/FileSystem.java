package name.mdemidov.interview.leetcode.task0588;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/design-in-memory-file-system/
 *
 * <p>588. Design In-Memory File System
 *
 * <p>Design an in-memory file system to simulate the following functions:
 *
 * <p>ls: Given a path in string format. If it is a file path, return a list that only contains this
 * file's name. If it is a directory path, return the list of file and directory names in this
 * directory. Your output (file and directory names together) should in lexicographic order.
 *
 * <p>mkdir: Given a directory path that does not exist, you should make a new directory according
 * to the path. If the middle directories in the path don't exist either, you should create them as
 * well. This function has void return type.
 *
 * <p>addContentToFile: Given a file path and file content in string format. If the file doesn't
 * exist, you need to create that file containing given content. If the file already exists, you
 * need to append given content to original content. This function has void return type.
 *
 * <p>readContentFromFile: Given a file path, return its content in string format.
 *
 * <p>Example:
 *
 * <p>Input: ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 *
 * <p>Output: [null,[],null,null,["a"],"hello"]
 *
 * <p>Note:
 *
 * <p>You can assume all file or directory paths are absolute paths which begin with / and do not
 * end with / except that the path is just "/".
 *
 * <p>You can assume that all operations will be passed valid parameters and users will not attempt
 * to retrieve file content or list a directory or file that does not exist.
 *
 * <p>You can assume that all directory names and file names only contain lower-case letters, and
 * same names won't exist in the same directory.
 */
public class FileSystem {

  private static final String SEPARATOR = "/";

  private final FsItem root;

  public FileSystem() {
    root = new Dir();
  }

  public List<String> ls(String path) {
    String[] dirs = path.split(SEPARATOR);
    FsItem node = root;
    for (String dir : dirs) {
      if (dir.isEmpty()) {
        continue;
      }
      node = ((Dir) node).children.get(dir);
      if (node instanceof File) {
        return Collections.singletonList(dir);
      }
    }
    return new ArrayList<>(((Dir) node).children.keySet());
  }

  public void mkdir(String path) {
    String[] dirs = path.split(SEPARATOR);
    FsItem node = root;
    for (String dir : dirs) {
      if (dir.isEmpty()) {
        continue;
      }
      ((Dir) node).children.putIfAbsent(dir, new Dir());
      node = ((Dir) node).children.get(dir);
    }
  }

  public void addContentToFile(String filePath, String content) {
    String[] dirs = filePath.split(SEPARATOR);
    FsItem node = root;
    for (int i = 1; i < dirs.length - 1; i++) {
      String dir = dirs[i];
      ((Dir) node).children.putIfAbsent(dir, new Dir());
      node = ((Dir) node).children.get(dir);
    }
    String dir = dirs[dirs.length - 1];
    FsItem file = ((Dir) node).children.getOrDefault(dir, new File());
    ((File) file).content.append(content);
    ((Dir) node).children.put(dir, file);
  }

  public String readContentFromFile(String filePath) {
    String[] dirs = filePath.split(SEPARATOR);
    FsItem node = root;
    for (String dir : dirs) {
      if (dir.isEmpty()) {
        continue;
      }
      node = ((Dir) node).children.get(dir);
    }
    return ((File) node).content.toString();
  }

  private interface FsItem {}

  private static final class Dir implements FsItem {
    TreeMap<String, FsItem> children = new TreeMap<>();
  }

  private static final class File implements FsItem {
    StringBuilder content = new StringBuilder();
  }

  public static void main(String[] args) {
    FileSystem fs = new FileSystem();
    System.out.println(fs.ls("/")); // []
    fs.mkdir("/a/b/c");
    fs.addContentToFile("/a/b/c/d", "hello");
    System.out.println(fs.ls("/")); // ["a"]
    System.out.println(fs.readContentFromFile("/a/b/c/d")); // "hello"
    fs.mkdir("/a/b/c/abc");
    fs.mkdir("/a/b/c/eee");
    System.out.println(fs.ls("/a/b/c")); // ["abc, d, eee"]
    fs.addContentToFile("/a/b/c/d", " bye");
    System.out.println(fs.readContentFromFile("/a/b/c/d")); // "hello bye"
  }
}
