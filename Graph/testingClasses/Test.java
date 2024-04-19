package Graph.testingClasses;

import Graph.graphClasses.AdjacencyListGraph.AdjacencyListGraphUndirected;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCommands = sc.nextInt();
        AdjacencyListGraphUndirected<Integer> graph = new AdjacencyListGraphUndirected<>();
        for (int i = 0; i < numCommands; i++) {
            String[] inputString = sc.nextLine().split(" ");
            if (inputString[0].equals("PRINTGRAPH")) {
                graph.print();
            } else if (inputString[0].equals("ADDEDGE")) {
                graph.addEdge(Integer.parseInt(inputString[1]), Integer.parseInt(inputString[2]));
            } else if (inputString[0].equals("DELETEEDGE")) {
                graph.removeEdge(Integer.parseInt(inputString[1]), Integer.parseInt(inputString[2]));
            } else if (inputString[0].equalsIgnoreCase("ADJACENT")) {
                System.out.println(graph.getNeighbours(Integer.parseInt(inputString[1]))
                        .contains(Integer.parseInt(inputString[2])));
            }
        }

    }

}
