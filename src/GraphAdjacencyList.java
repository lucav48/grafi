import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GraphAdjacencyList<T> implements Graph<T> {
    private Map<T, Map<T, Integer>> adjacencyList;

    public GraphAdjacencyList() {
        adjacencyList = new HashMap<>();
    }

    @Override
    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new HashMap<>());
    }

    @Override
    public void addEdge(T source, T destination) {
        adjacencyList.putIfAbsent(source, new HashMap<>());
        adjacencyList.putIfAbsent(destination, new HashMap<>());
        adjacencyList.get(source).put(destination, 1);
        adjacencyList.get(destination).put(source, 1);
    }

    @Override
    public List<T> getNeighbors(T vertex) {
        List<T> neighbors = new ArrayList<>();
        Map<T, Integer> edges = adjacencyList.get(vertex);
        if (edges != null) {
            for (T neighbor : edges.keySet()) {
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    @Override
    public void displayGraph() {
        for (T source : adjacencyList.keySet()) {
            System.out.print(source + " -> ");
            for (T destination : adjacencyList.get(source).keySet()) {
                System.out.print(destination + " ");
            }
            System.out.println();
        }
    }
}
