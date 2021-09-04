package name.mdemidov.interview.algorithm.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {

  private Map<Integer, List<Integer>> edges;

  public Graph(int... vertices) {
    this();
    addVertices(vertices);
  }

  public Graph() {
    edges = new HashMap<>();
  }

  public void addVertices(int... vertices) {
    for (int vertex : vertices) {
      edges.put(vertex, new LinkedList<>());
    }
  }

  public void addEdge(int from, int to) {
    if (!edges.containsKey(from)) {
      throw new IllegalStateException("Vertex not found: " + from);
    }
    List<Integer> list = edges.getOrDefault(from, new LinkedList<>());
    list.add(to);
    edges.put(from, list);
  }

  public static void main(String[] args) {
    Graph g = new Graph(0, 1, 2, 3);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println(g.bfs(2)); // 2 0 3 1
    System.out.println(g.dfs(2)); // 2 0 1 3
  }

  public List<Integer> bfs(int source) {
    List<Integer> visited = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(source);
    while (!queue.isEmpty()) {
      int vertex = queue.poll();
      if (visited.contains(vertex)) {
        continue;
      }
      visited.add(vertex);
      queue.addAll(edges.get(vertex));
    }
    return visited;
  }

  public List<Integer> dfs(int source) {
    return dfs(source, new LinkedList<>());
  }

  private List<Integer> dfs(int source, List<Integer> visited) {
    visited.add(source);
    for (int vertex : edges.get(source)) {
      if (!visited.contains(vertex)) {
        dfs(vertex, visited);
      }
    }
    return visited;
  }
}
