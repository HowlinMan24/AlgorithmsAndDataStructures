package Graph.testingClasses;

import Graph.graphClasses.AdjacencyListGraph.AdjacencyListGraphUndirected;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numUsers = sc.nextInt();
        sc.nextLine();
        AdjacencyListGraphUndirected<String> graph = new AdjacencyListGraphUndirected<>();
        for (int i = 0; i < numUsers; i++) {
            String input = sc.nextLine();
            graph.addVertex(input);
            int numberFriends = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < numberFriends; j++) {
                String inputPerson = sc.nextLine();
                graph.addEdge(input, inputPerson);
            }
        }
        String start = sc.next();
        String end = sc.next();
        System.out.println(graph.findPathDistance(start, end));

    }


}
