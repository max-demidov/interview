package name.mdemidov.interview.algorithm.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DijkstraAlgorithm {

  static Vertex a;
  static Vertex b;
  static Vertex c;
  static Vertex d;
  static Vertex e;
  static Vertex f;

  private static void init() {
    a = new Vertex("A");
    b = new Vertex("B");
    c = new Vertex("C");
    d = new Vertex("D");
    e = new Vertex("E");
    f = new Vertex("F");
    a.addEdge(10, b);
    a.addEdge(20, c);
    b.addEdge(5, c);
    b.addEdge(15, d);
    b.addEdge(30, e);
    c.addEdge(7, d);
    c.addEdge(20, f);
    d.addEdge(6, f);
    f.addEdge(4, e);
  }

  public static void main(String[] args) {
    init();
    System.out.println(shortestPath(a, e)); // [A(0), B(10), C(15), D(22), F(28), E(32)]
    init();
    System.out.println(shortestPath(f, b)); // []
    init();
    System.out.println(shortestPath(c, c)); // []
  }

  public static List<Vertex> shortestPath(Vertex from, Vertex to) {
    from.minDist = 0;
    Set<Vertex> visited = new HashSet<>();
    Queue<Vertex> unvisited = new LinkedList<>();
    unvisited.offer(from);
    while (!unvisited.isEmpty()) {
      Vertex vertex = unvisited.poll();
      for (Edge edge : vertex.outbound) {
        int dist = vertex.minDist + edge.dist;
        if (dist < edge.to.minDist) {
          edge.to.minDist = dist;
          edge.to.prev = vertex;
        }
        if (!visited.contains(edge.to)) {
          unvisited.offer(edge.to);
        }
      }
      visited.add(vertex);
    }

    LinkedList<Vertex> path = new LinkedList<>();
    if (to.prev == null) {
      return path;
    }
    Vertex cur = to;
    while (cur != null) {
      path.addFirst(cur);
      cur = cur.prev;
    }
    return path;
  }
}
