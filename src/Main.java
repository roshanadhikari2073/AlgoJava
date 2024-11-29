public class Main {
    public static void main(String[] args) {
        DFS g1 = new DFS();
        g1.addEdge(1,2);
        g1.addEdge(1,3);

        System.out.println(g1.hasDFS(1,3));
    }
}