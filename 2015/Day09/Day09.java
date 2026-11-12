package Day09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;


public class Day09 {
	private int solution1 = 0;
	private int solution2 = 0;
	static Scanner in;
	static List<String> input = new LinkedList<>();

	public static void main(String[] args) {
		Day09 day09 = new Day09();
		Day09.solution(day09);
		System.out.println("Solution 1: " + day09.getSolution1());
		System.out.println("Solution 2: " + day09.getSolution2());
	}

	private static void solution(Day09 day09) {

		StringBuilder sb = new StringBuilder();
		try {
			in = new Scanner(new FileReader("./src/Day09/Day09.txt"));
			while (in.hasNext()) {
				sb = new StringBuilder().append(in.nextLine());
				input.add(sb.toString());
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
		
		day09.setSolution1(day09.getSolution1() + solution1());
		day09.setSolution2(day09.getSolution2() + solution2(sb.toString()));
	}

	private static int solution1() {
		Graph graph = new Graph();
		
		List<Node> tmp = new LinkedList<>();
		for (String string : input) {
			Node start = new Node(string.split(" to ")[0]);
			Node end = new Node(string.split(" to ")[1].split(" = ")[0]);
			
			for (int i = 0; i < tmp.size(); i++) {
				if (tmp.contains(start)) {
					Node node = tmp.get(i);
					node.addDestination(end, Integer.parseInt(string.split(" to ")[1].split(" = ")[1]));
				} else {
					start.addDestination(end, Integer.parseInt(string.split(" to ")[1].split(" = ")[1]));
					tmp.add(start);
				}
			}		
		}
		
		for (Node node : tmp) {
			graph.addNode(node);
		}
		
		Node n = new Node("tmp");
		calculateShortestPathFromSource(graph, n);
		
		return 0;
	}

	private static int solution2(String string) {
		return 0;
	}

	public int getSolution1() {
		return solution1;
	}

	public void setSolution1(int solution1) {
		this.solution1 = solution1;
	}

	public int getSolution2() {
		return solution2;
	}

	public void setSolution2(int solution2) {
		this.solution2 = solution2;
	}

	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

}

class Graph {

	 private Set<Node> nodes = new HashSet<>();

	    public void addNode(Node nodeA) {
	        nodes.add(nodeA);
	    }

	    public Set<Node> getNodes() {
	        return nodes;
	    }

	    public void setNodes(Set<Node> nodes) {
	        this.nodes = nodes;
	    }    
}

class Node {
	private String name;

	private LinkedList<Node> shortestPath = new LinkedList<>();

	private Integer distance = Integer.MAX_VALUE;

	private Map<Node, Integer> adjacentNodes = new HashMap<>();

	public Node(String name) {
		this.name = name;
	}

	public void addDestination(Node destination, int distance) {
		adjacentNodes.put(destination, distance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(LinkedList<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

}
