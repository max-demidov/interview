package name.mdemidov.interview.algorithm.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DijkstraAlgorithm {

  static Node a;
  static Node b;
  static Node c;
  static Node d;
  static Node e;
  static Node f;

  private static void init() {
    a = new Node("A");
    b = new Node("B");
    c = new Node("C");
    d = new Node("D");
    e = new Node("E");
    f = new Node("F");
    a.edgeTo(b, 10);
    a.edgeTo(c, 15);
    b.edgeTo(d, 12);
    b.edgeTo(f, 15);
    c.edgeTo(e, 10);
    d.edgeTo(f, 1);
    d.edgeTo(e, 2);
    f.edgeTo(e, 5);
  }

  public static void main(String[] args) {
    init();
    System.out.println(shortestPath(a, e)); // [A(0), B(10), D(22), E(24)]
    init();
    System.out.println(shortestPath(a, f)); // [A(0), B(10), D(22), F(23)]
    init();
    System.out.println(shortestPath(b, e)); // [B(0), D(12), E(14)]
    init();
    System.out.println(shortestPath(b, f)); // [B(0), D(12), F(13)]
    init();
    System.out.println(shortestPath(b, c)); // []
    init();
    System.out.println(shortestPath(b, b)); // []
  }

  public static List<Node> shortestPath(Node from, Node to) {
    from.shortestPath = 0;
    Set<Node> visited = new HashSet<>();
    Queue<Node> unvisited = new LinkedList<>();
    unvisited.offer(from);
    while (!unvisited.isEmpty()) {
      Node cur = unvisited.poll();
      for (Edge edge : cur.next) {
        if (visited.contains(edge.to)) {
          continue;
        }
        int dist = cur.shortestPath + edge.dist;
        if (dist < edge.to.shortestPath) {
          edge.to.shortestPath = dist;
          edge.to.prev = cur;
        }
        unvisited.offer(edge.to);
      }
      visited.add(cur);
    }

    LinkedList<Node> path = new LinkedList<>();
    if (to.prev == null) {
      return path;
    }
    Node cur = to;
    while (cur != null) {
      path.addFirst(cur);
      cur = cur.prev;
    }
    return path;
  }
}
