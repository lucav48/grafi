import java.util.List;

public interface Graph<T> {
    void addVertex(T vertex);
    void addEdge(T source, T destination);
    List<T> getNeighbors(T vertex);
    void displayGraph();
}
