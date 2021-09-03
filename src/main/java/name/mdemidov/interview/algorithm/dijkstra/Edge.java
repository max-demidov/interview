package name.mdemidov.interview.algorithm.dijkstra;

public class Edge {

  Node to;
  int dist;

  public Edge(Node to, int dist) {
    this.to = to;
    this.dist = dist;
  }
}
