package name.mdemidov.interview.algorithm.dijkstra;

public class Edge {

  int dist;
  Vertex to;

  public Edge(int dist, Vertex to) {
    this.dist = dist;
    this.to = to;
  }
}
