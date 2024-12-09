import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class GraphAdjacencyMap<T> implements Graph<T> {
    private Map<T, List<T>> adjacencyMap;

    public GraphAdjacencyMap() {
        adjacencyMap = new HashMap<>();
    }

    @Override
    public void addVertex(T vertex) {
        adjacencyMap.putIfAbsent(vertex, new ArrayList<>());
    }

    @Override
    public void addEdge(T source, T destination) {
        adjacencyMap.putIfAbsent(source, new ArrayList<>());
        adjacencyMap.putIfAbsent(destination, new ArrayList<>());
        adjacencyMap.get(source).add(destination);
        adjacencyMap.get(destination).add(source); // For undirected graph
    }

    @Override
    public List<T> getNeighbors(T vertex) {
        return adjacencyMap.getOrDefault(vertex, new ArrayList<>());
    }

    @Override
    public void displayGraph() {
        for (T vertex : adjacencyMap.keySet()) {
            System.out.print(vertex + " -> ");
            for (T neighbor : adjacencyMap.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
