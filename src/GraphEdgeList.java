import java.util.ArrayList;
import java.util.List;

class GraphEdgeList<T> implements Graph<T> {
    private List<Pair<T, T>> edges;

    public GraphEdgeList() {
        edges = new ArrayList<>();
    }

    @Override
    public void addVertex(T vertex) {    }

    @Override
    public void addEdge(T source, T destination) {
        edges.add(new Pair<>(source, destination));
    }

    @Override
    public List<T> getNeighbors(T vertex) {
        List<T> neighbors = new ArrayList<>();
        for (Pair<T, T> edge : edges) {
            if (edge.getFirst().equals(vertex)) neighbors.add(edge.getSecond());
            if (edge.getSecond().equals(vertex)) neighbors.add(edge.getFirst()); // For undirected graph
        }
        return neighbors;
    }

    @Override
    public void displayGraph() {
        for (Pair<T, T> edge : edges) {
            System.out.println(edge.getFirst() + " -> " + edge.getSecond());
        }
    }

    private static class Pair<U, V> {
        private U first;
        private V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public U getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }
}
