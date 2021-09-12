package name.mdemidov.interview.algorithm.dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Vertex {
  String name;
  int minDist;
  Vertex prev;
  PriorityQueue<Edge> outbound;

  public Vertex(String name) {
    this.name = name;
    minDist = Integer.MAX_VALUE;
    prev = null;
    outbound = new PriorityQueue<>(Comparator.comparingInt(e -> e.dist));
  }

  public void addEdge(int dist, Vertex to) {
    outbound.offer(new Edge(dist, to));
  }

  @Override
  public String toString() {
    return String.format("%s(%d)", name, minDist < Integer.MAX_VALUE ? minDist : -1);
  }
}
