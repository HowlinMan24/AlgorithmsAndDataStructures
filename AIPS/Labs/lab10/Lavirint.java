package AIPS.Labs.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Stack;

import java.util.LinkedList;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

interface Queue<E> {

    // Elementi na redicata se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.

}

class LinkedQueue<E> implements Queue<E> {
    SLLNode<E> front, rear;
    int length;

    public LinkedQueue() {
        clear();
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public E peek() {
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear() {
        front = rear = null;
        length = 0;
    }

    public void enqueue(E x) {
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue() {
        if (front != null) {
            E frontMost = front.element;
            front = front.succ;
            if (front == null) rear = null;
            length--;
            return frontMost;
        } else
            throw new NoSuchElementException();
    }

}

class GraphNode<E> {
    private int index;
    private E info;
    private LinkedList<GraphNode<E>> neighbors;

    public GraphNode(int index, E info) {
        this.index = index;
        this.info = info;
        neighbors = new LinkedList<GraphNode<E>>();
    }

    boolean containsNeighbor(GraphNode<E> o) {
        return neighbors.contains(o);
    }

    void addNeighbor(GraphNode<E> o) {
        neighbors.add(o);
    }

    void removeNeighbor(GraphNode<E> o) {
        if (neighbors.contains(o))
            neighbors.remove(o);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("INFO:" + info + " SOSEDI:");
        for (GraphNode<E> neighbor : neighbors)
            ret.append(neighbor.info).append(" ");
        return ret.toString();

    }

    @Override
    public boolean equals(Object obj) {
        @SuppressWarnings("unchecked")
        GraphNode<E> pom = (GraphNode<E>) obj;
        return (pom.info.equals(this.info));
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public LinkedList<GraphNode<E>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(LinkedList<GraphNode<E>> neighbors) {
        this.neighbors = neighbors;
    }

}


class ListGraph<E> {

    int num_nodes;
    GraphNode<E>[] adjList;

    @SuppressWarnings("unchecked")
    public ListGraph(int num_nodes, E[] list) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            adjList[i] = new GraphNode<E>(i, list[i]);
    }

    @SuppressWarnings("unchecked")
    public ListGraph(int num_nodes) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
    }

    int adjacent(int x, int y) {
        return (adjList[x].containsNeighbor(adjList[y])) ? 1 : 0;
    }

    void addEdge(int x, int y) {
        adjList[x].addNeighbor(adjList[y]);
    }

    void deleteEdge(int x, int y) {
        adjList[x].removeNeighbor(adjList[y]);
    }

    void dfsSearch(int node) {
        boolean[] visited = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        dfsRecursive(node, visited);
    }

    void dfsRecursive(int node, boolean[] visited) {
        visited[node] = true;
        System.out.println(node + ": " + adjList[node].getInfo());

        for (int i = 0; i < adjList[node].getNeighbors().size(); i++) {
            GraphNode<E> pom = adjList[node].getNeighbors().get(i);
            if (!visited[pom.getIndex()])
                dfsRecursive(pom.getIndex(), visited);
        }
    }

    void dfsNonrecursive(int node) {
        boolean[] visited = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        visited[node] = true;
        System.out.println(node + ": " + adjList[node].getInfo());
        Stack<Integer> s = new Stack<Integer>();
        s.push(node);

        GraphNode<E> pom;

        while (!s.isEmpty()) {
            pom = adjList[s.peek()];
            GraphNode<E> tmp = null;
            for (int i = 0; i < pom.getNeighbors().size(); i++) {
                tmp = pom.getNeighbors().get(i);
                if (!visited[tmp.getIndex()])
                    break;
            }
            if (tmp != null && !visited[tmp.getIndex()]) {
                visited[tmp.getIndex()] = true;
                System.out.println(tmp.getIndex() + ": " + tmp.getInfo());
                s.push(tmp.getIndex());
            } else
                s.pop();
        }

    }


    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < this.num_nodes; i++)
            ret.append(i).append(": ").append(adjList[i]).append("\n");
        return ret.toString();
    }

    public void findPath(int start, int end, int width) {
        Stack<Integer> path = new Stack<Integer>();
        boolean[] visited = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;

        visited[start] = true;
        path.push(start);
        Queue<Integer> q = new LinkedQueue<Integer>();
        q.enqueue(start);

        GraphNode<E> pom;

        while (!q.isEmpty()) {
            pom = adjList[q.dequeue()];
            GraphNode<E> tmp = null;
            boolean change = false;
            boolean found = false;
            for (int i = 0; i < pom.getNeighbors().size(); i++) {
                tmp = pom.getNeighbors().get(i);
                if (!visited[tmp.getIndex()]) {
                    change = true;
                    visited[tmp.getIndex()] = true;
                    path.push(tmp.getIndex());
                    if (tmp.getIndex() == end) {
                        found = true;
                        break;
                    }
                    q.enqueue(tmp.getIndex());
                }
            }
            if (found) break;
            if (!change) path.pop();
        }


        Stack<Integer> reverseOrder = new Stack<Integer>();
        while (!path.isEmpty()) {
            reverseOrder.push(path.pop());
        }
        while (!reverseOrder.isEmpty()) {
            int val = reverseOrder.pop();
            System.out.println(val / width + "," + val % width);
        }

    }

    void bfs(int node) {
        boolean visited[] = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        visited[node] = true;
        System.out.println(node + ": " + adjList[node].getInfo());
        Queue<Integer> q = new LinkedQueue<Integer>();
        q.enqueue(node);

        GraphNode<E> pom;

        while (!q.isEmpty()) {
            pom = adjList[q.dequeue()];
            GraphNode<E> tmp = null;
            for (int i = 0; i < pom.getNeighbors().size(); i++) {
                tmp = pom.getNeighbors().get(i);
                if (!visited[tmp.getIndex()]) {
                    visited[tmp.getIndex()] = true;
                    q.enqueue(tmp.getIndex());
                }
            }
        }

    }
}


public class Lavirint {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(bf.readLine().split(",")).mapToInt(x -> Integer.parseInt(x)).toArray();
        Character[][] maze = new Character[size[0]][size[1]];
        Character[] nodes = new Character[size[0] * size[1]];

        for (int i = 0; i < size[0]; i++) {
            String line = bf.readLine();
            for (int j = 0; j < size[1]; j++) {
                maze[i][j] = line.charAt(j);
                nodes[i * size[1] + j] = line.charAt(j);
            }
        }

        ListGraph<Character> graph = new ListGraph<Character>(size[0] * size[1], nodes);
        int startNode = 0, endNode = 0;

        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                if (maze[i][j] != '#') {
                    if (maze[i][j] == 'S') startNode = i * size[1] + j;
                    if (maze[i][j] == 'E') endNode = i * size[1] + j;

                    if (i - 1 >= 0 && maze[i - 1][j] != '#') graph.addEdge(i * size[1] + j, (i - 1) * size[1] + j);
                    if (i + 1 < size[0] && maze[i + 1][j] != '#') graph.addEdge(i * size[1] + j, (i + 1) * size[1] + j);
                    if (j - 1 >= 0 && maze[i][j - 1] != '#') graph.addEdge(i * size[1] + j, i * size[1] + j - 1);
                    if (j + 1 < size[1] && maze[i][j + 1] != '#') graph.addEdge(i * size[1] + j, i * size[1] + j + 1);
                }
            }
        }

        graph.findPath(startNode, endNode, size[1]);

    }
}
