package name.mdemidov.interview.algorithm.dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Node {
  String name;
  int shortestPath;
  Node prev;
  PriorityQueue<Edge> next;

  public Node(String name) {
    this.name = name;
    shortestPath = Integer.MAX_VALUE;
    prev = null;
    next = new PriorityQueue<>(Comparator.comparingInt(e -> e.dist));
  }

  public void edgeTo(Node node, int dist) {
    next.offer(new Edge(node, dist));
  }

  @Override
  public String toString() {
    return String.format("%s(%d)", name, shortestPath < Integer.MAX_VALUE ? shortestPath : -1);
  }
}
