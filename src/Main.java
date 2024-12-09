public class Main {
    public static void main(String[] args) {
        System.out.println("Edge List Graph:");
        Graph<String> edgeListGraph = new GraphEdgeList<>();
        edgeListGraph.addEdge("A", "B");
        edgeListGraph.addEdge("B", "C");
        edgeListGraph.displayGraph();

        System.out.println("\nAdjacency List Graph:");
        Graph<String> adjacencyListGraph = new GraphAdjacencyList<>();
        adjacencyListGraph.addVertex("A");
        adjacencyListGraph.addVertex("B");
        adjacencyListGraph.addEdge("A", "B");
        adjacencyListGraph.addEdge("B", "C");
        adjacencyListGraph.displayGraph();

        System.out.println("\nAdjacency Map Graph:");
        Graph<String> adjacencyMapGraph = new GraphAdjacencyMap<>();
        adjacencyMapGraph.addVertex("A");
        adjacencyMapGraph.addVertex("B");
        adjacencyMapGraph.addEdge("A", "B");
        adjacencyMapGraph.addEdge("B", "C");
        adjacencyMapGraph.displayGraph();

        System.out.println("\nAdjacency Matrix Graph:");
        GraphAdjacencyMatrix<String> adjacencyMatrixGraph = new GraphAdjacencyMatrix<>();
        adjacencyMatrixGraph.addVertex("A");
        adjacencyMatrixGraph.addVertex("B");
        adjacencyMatrixGraph.addVertex("C");
        adjacencyMatrixGraph.addVertex("D");

        adjacencyMatrixGraph.addEdge("A", "B");
        adjacencyMatrixGraph.addEdge("A", "C");
        adjacencyMatrixGraph.addEdge("B", "D");
        adjacencyMatrixGraph.addEdge("C", "D");


        adjacencyMatrixGraph.bfs("A"); // Expected Output: BFS Traversal: A B C D
        adjacencyMatrixGraph.dfs("A"); // Expected Output: DFS Traversal: A B D C
    }
}
