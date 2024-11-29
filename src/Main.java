public class Main {
    public static void main(String[] args) {
        Graph g1 = new Graph();
        g1.addEdge(1,2);
        g1.addEdge(1,3);

        System.out.println(g1.hasDFS(1,3));
        System.out.println(g1.hasBFS(1,3));
    }
}