package Graph.graphClasses.AdjacencyMatrixGraph;

import Graph.graphClasses.AdjacencyListGraph.AdjacencyListGraphUndirected;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph<T> {
    private int numVertices;
    private int[][] matrix; // Matrix for adjacency
    private T[] vertices; // An array for all the vertices in the graph

    @SuppressWarnings("unchecked")
    public AdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        this.matrix = new int[numVertices][numVertices];
        this.vertices = (T[]) new Object[numVertices];
    }

    public void addVertex(int index, T data) {
        vertices[index] = data;
    }

    public T getVertex(int index) {
        return vertices[index];
    }

    public void addEdge(int source, int destination) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1; // this is for an undirected graph
    }

    public boolean isEdge(int source, int destination) {
        return matrix[source][destination] == 1;
    }

    public void removeEdge(int source, int destination) {
        matrix[source][destination] = 0;
        matrix[destination][source] = 0; // this is for an undirected graph
    }

    @SuppressWarnings("unchecked")
    public void removeVertex(int vertexIndex) {
        if (vertexIndex < 0 || vertexIndex >= numVertices)
            throw new IndexOutOfBoundsException("Vertex index out of bounds!");
        int[][] newMatrix = new int[numVertices - 1][numVertices - 1];
        T[] newVertices = (T[]) new Object[numVertices - 1];
        int ni = 0;
        for (int i = 0; i < numVertices; i++) {
            if (i == vertexIndex)
                continue;
            int nj = 0;
            for (int j = 0; j < numVertices; j++) {
                if (j == vertexIndex)
                    continue;
                newMatrix[ni][nj] = matrix[i][j];
                nj++;
            }
            newVertices[ni] = vertices[i];
            ni++;
        }
        matrix = newMatrix;
        vertices = newVertices;
        numVertices--;
    }

    public List<T> getNeighbours(int vertexIndex) {
        List<T> neighbours = new ArrayList<>();
        for (int i = 0; i < matrix[vertexIndex].length; i++) {
            if (matrix[vertexIndex][i] == 1) {
                neighbours.add(vertices[i]);
            }
        }
        return neighbours;
    }

    public AdjacencyListGraphUndirected<T> toAdjacencyList() {
        AdjacencyListGraphUndirected<T> graph = new AdjacencyListGraphUndirected<>();

        for (int i = 0; i < numVertices; i++) {
            graph.addVertex(vertices[i]);
        }

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrix[i][j] > 0) {
                    graph.addEdge(vertices[i], vertices[j]);
                }

            }
        }

        return graph;


    }
}