// Author: Roshan Adhikari
// DFS - Gayle Lakman McDowell Graphs

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class DFS {

    private LinkedHashMap<Integer, Node> nodeLookUp = new LinkedHashMap<>();

    private static class Node {
        Integer id;
        LinkedList<Node> adjacent = new LinkedList<>();
        private Node(Integer id) {this.id = id;}
    }

    private Node getNode(Integer id) {
        if(!nodeLookUp.containsKey(id)) {
            Node node = new Node(id);
            nodeLookUp.put(id, node);
        }
        return nodeLookUp.get(id);
    }

    public void addEdge(Integer source, Integer destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasDFS(Integer source, Integer destination) {
        Node s = getNode(source);
        HashSet<Integer> visitedList = new HashSet<>();
        return hasDFS(s, destination, visitedList);
    }

    private boolean hasDFS(Node source, Integer destination, HashSet<Integer> visitedNodes) {
        if(source.id == destination) return true;
        if(visitedNodes.contains(source.id)) return false;

        for(Node child: source.adjacent) {
            if(hasDFS(child, destination, visitedNodes)) return true;
        }
        return false;
    }
}
