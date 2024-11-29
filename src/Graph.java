// Author: Roshan Adhikari
// DFS - Gayle Lakman McDowell Graphs

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Graph {

    private LinkedHashMap<Integer, Node> nodeLookUp = new LinkedHashMap<>();

    private static class Node {
        Integer id;
        LinkedList<Node> adjacent = new LinkedList<>();
        private Node(Integer id) {this.id = id;}
    }

    private Node getNode(Integer id) {
        if(!nodeLookUp.containsKey(id)) nodeLookUp.put(id, new Node(id));
        return nodeLookUp.get(id);
    }

    public void addEdge(Integer source, Integer destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasDFS(Integer source, Integer destination) {
        return hasDFS(getNode(source), destination, new HashSet<Integer>());
    }

    private boolean hasDFS(Node source, Integer destination, HashSet visitedNodes) {
        if(source.id == destination) return true;
        if(visitedNodes.contains(source.id)) return false;

        visitedNodes.add(source.id);

        for(Node child: source.adjacent) {
            if(hasDFS(child, destination, visitedNodes)) return true;
        }
        return false;
    }

    public boolean hasBFS(Integer source, Integer destination) {
        return hasBFS(getNode(source), getNode(destination), new HashSet<Integer>());
    }

    private boolean hasBFS(Node source, Node destination, HashSet alreadyVisited) {
        LinkedList<Node> nextNodes = new LinkedList<>();
        nextNodes.add(source);

        while(!nextNodes.isEmpty()) {
            Node node = nextNodes.remove();
            if(node == destination) return true;
            if(alreadyVisited.contains(node.id)) continue;
            alreadyVisited.add(node.id);

            for(Node child: node.adjacent) {
                nextNodes.add(child);
            }
        }
        return false;
    }
}
