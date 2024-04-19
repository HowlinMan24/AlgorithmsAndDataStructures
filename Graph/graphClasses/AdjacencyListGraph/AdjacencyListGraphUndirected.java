package Graph.graphClasses.AdjacencyListGraph;

import java.util.*;

public class AdjacencyListGraphUndirected<T> {
    private Map<T, Set<T>> adjacencyList;

    public AdjacencyListGraphUndirected() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
        }
    }

    public void removeVertex(T vertex) {
        for (Set<T> neighbours : adjacencyList.values()) {
            neighbours.remove(vertex);
        }
        adjacencyList.remove(vertex);
    }

    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // for undirected
    }

    public void removeEdge(T source, T destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }
        if (adjacencyList.containsKey(destination)) { // for undirected
            adjacencyList.get(destination).remove(source);
        }

    }

    public Set<T> getNeighbours(T vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }

    public void DFS(T startVertex) { // Recursive
        Set<T> visited = new HashSet<>();
        DFSUtil(startVertex, visited);
    }

    private void DFSUtil(T vertex, Set<T> visited) {
        visited.add(vertex);

        for (T neighbour : getNeighbours(vertex)) {
            if (!visited.contains(neighbour)) {
                DFSUtil(neighbour, visited);
            }
        }

    }

    public void DFSNonRecursive(T startVertex) { // Non-Recursive
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            T vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (T neighbour : getNeighbours(vertex)) {
                    if (!visited.contains(neighbour)) {
                        stack.push(neighbour);
                    }
                }
            }
        }

    }

    public int numPools(T startVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        stack.push(startVertex);
        int maxPools = 0;
        while (!stack.isEmpty()) {
            T vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (T neighbour : getNeighbours(vertex)) {
                    if (!visited.contains(neighbour)) {
                        stack.push(neighbour);
                    }
                }
                maxPools++;
            }
        }
        return maxPools-1;
    }

    public void BFS(T startVertex) { // Non-Recursive
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            T vertex = queue.poll();

            for (T neighbour : getNeighbours(vertex)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }

        }

    }

    public void findPath(T startVertex, T endVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> invertedPath = new Stack<>();
        visited.add(startVertex);
        invertedPath.push(startVertex);

        while (!invertedPath.isEmpty() && !invertedPath.peek().equals(endVertex)) {
            T currentVertex = invertedPath.peek();
            T current = currentVertex;

            for (T vertex : getNeighbours(currentVertex)) {
                current = vertex;
                if (!visited.contains(vertex)) {
                    break;
                }
                if (!visited.contains(current)) {
                    visited.add(current);
                    invertedPath.push(current);
                } else {
                    invertedPath.pop();
                }
            }

        }

    }

    public int findPathDistance(T startVertex, T endVertex) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        int minDistance = 0;
        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            if (endVertex.equals(vertex)) {
                break;
            }
            for (T neighbour : getNeighbours(vertex)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
            minDistance++;
        }
        return minDistance;
    }

    public void print() {
        adjacencyList.forEach((x, y) ->
                System.out.printf("%s: %s\n", x.toString(), new ArrayList<T>(y)));
        System.out.println();
    }

    public Map<T, Set<T>> getAdjacencyList() {
        return adjacencyList;
    }
}
