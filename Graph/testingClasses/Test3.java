package Graph.testingClasses;

import Graph.graphClasses.AdjacencyListGraph.AdjacencyListGraphUndirected;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numPools = Integer.parseInt(br.readLine().replace(" ", ""));
        int numRivers = Integer.parseInt(br.readLine().replace(" ", ""));
        AdjacencyListGraphUndirected<Integer> graph = new AdjacencyListGraphUndirected<>();
        for (int i = 0; i < numRivers; i++) {
            String[] parts = br.readLine().split("\\s+");
            if (!graph.getAdjacencyList().containsKey(Integer.parseInt(parts[0]))) {
                graph.addVertex(Integer.parseInt(parts[0]));
            }
            graph.addEdge(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
        int lake = Integer.parseInt(br.readLine().replace(" ", ""));
        graph.print();
        System.out.println(graph.numPools(lake));
    }

}
