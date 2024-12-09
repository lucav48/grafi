import java.util.*;

class GraphAdjacencyMatrix<T> implements Graph<T> {
    private Map<T, Map<T, Integer>> adjacencyMatrix;

    public GraphAdjacencyMatrix() {
        adjacencyMatrix = new HashMap<>();
    }

    @Override
    public void addVertex(T vertex) {
        adjacencyMatrix.putIfAbsent(vertex, new HashMap<>());
    }

    @Override
    public void addEdge(T source, T destination) {
        adjacencyMatrix.putIfAbsent(source, new HashMap<>());
        adjacencyMatrix.putIfAbsent(destination, new HashMap<>());
        adjacencyMatrix.get(source).put(destination, 1);
        adjacencyMatrix.get(destination).put(source, 1); // For undirected graph
    }

    @Override
    public List<T> getNeighbors(T vertex) {
        List<T> neighbors = new ArrayList<>();
        Map<T, Integer> edges = adjacencyMatrix.get(vertex);
        if (edges != null) {
            for (T neighbor : edges.keySet()) {
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    @Override
    public void displayGraph() {
        for (T source : adjacencyMatrix.keySet()) {
            System.out.print(source + " -> ");
            for (T destination : adjacencyMatrix.get(source).keySet()) {
                System.out.print(destination + " ");
            }
            System.out.println();
        }
    }

    public void bfs(T start) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            T current = queue.poll();
            System.out.print(current + " ");
            for (T neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(T start) {
        Set<T> visited = new HashSet<>();
        System.out.print("DFS Traversal: ");
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(T vertex, Set<T> visited) {
        if (visited.contains(vertex)) {
            return;
        }

        visited.add(vertex);
        System.out.print(vertex + " ");

        for (T neighbor : getNeighbors(vertex)) {
            dfsRecursive(neighbor, visited);
        }
    }
}
