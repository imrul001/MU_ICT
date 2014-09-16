package sourcePackage;

import java.util.HashMap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections4.map.MultiValueMap;

public class GraphSearch {
	/**
	 * Main Method
	 * 
	 **/
	public static void main(String[] args){
		System.out.println("Here I am to take input");
		String[] nodeList = {"S", "A", "B", "D", "G", "C"};
		String[] startingNode = {"S"}; 
		String[] goalNode = {"G"};
		Map<String, Integer> edges = new HashMap<String, Integer>();
		edges.put("S_to_A", 1);
		edges.put("S_to_G", 12);
		edges.put("A_to_B", 3);
		edges.put("A_to_C", 1);
		edges.put("B_to_D", 3);
		edges.put("C_to_G", 2);
		edges.put("C_to_D", 1);
		edges.put("D_to_G", 3);
		
		MultiValueMap<String, String> adjacents = new MultiValueMap<String, String>();
		adjacents.put("S", "A");
		adjacents.put("S", "G");
		adjacents.put("A", "B");
		adjacents.put("A", "C");
		adjacents.put("B", "D");
		adjacents.put("C", "G");
		adjacents.put("C", "D");
		adjacents.put("D", "G");
		
		GraphSearch search = new GraphSearch();
		Graph graph = new Graph();
		graph = getInputSet();
		
//		search.performUCS(nodeList, startingNode, goalNode, edges, adjacents);
		search.performUCS(graph.getNodeList(), graph.getStartingNode(), graph.getGoalNode(), graph.getEdgesMap(), graph.getAjaceMap());
	}
	
	/**
	 *  Method to take input
	 * 
	 **/
	public static Graph getInputSet(){
		Graph graph = new Graph();
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many Nodes in your graph?");
		int numberofNodes = scanner.nextInt();
		String[] nodeList = new String[numberofNodes];
		String[] startingNode = new String[1];
		String[] endNode = new String[1];
		graph.setNumberOfNodes(numberofNodes);
		Map<String, Integer> edges = new HashMap<String, Integer>();
		MultiValueMap<String, String> adjacents = new MultiValueMap<String, String>();  
		
		for(int i=0; i< graph.getNumberOfNodes(); i++){
			Scanner scanner1 = new Scanner(System.in);
			System.out.println("Enter the Name of the node No. "+(i+1)+" ....");
			nodeList[i] = scanner1.next().trim();
			System.out.println("Enter the number of "+nodeList[i]+"'s neighbour(s) ....");
			int numberOFneighboursOfI = scanner1.nextInt();
			String[] neighbours = new String[numberOFneighboursOfI];
			int[] pathCostOfNeighbour = new int[numberOFneighboursOfI];
			for(int j = 0; j < numberOFneighboursOfI; j++){
				Scanner scanner2 = new Scanner(System.in);
				System.out.println("Name of the Neighbour No." +(j+1)+" of "+nodeList[i]);
				neighbours[j] = scanner2.next().trim();
				adjacents.put(nodeList[i], neighbours[j]);
				System.out.println("Cost/Distance for "+nodeList[i]+"_to_"+neighbours[j]+" ....");
				pathCostOfNeighbour[j] = scanner2.nextInt();
				edges.put(nodeList[i]+"_to_"+neighbours[j], pathCostOfNeighbour[j]);
			}	
		}
		System.out.println("Enter the Current/Starting Node....");
		startingNode[0] = scanner.next().trim();
		System.out.println("Enter the Goal/Ending Node....");
		endNode[0] = scanner.next().trim();
		

		graph.setNodeList(nodeList);
		graph.setStartingNode(startingNode);
		graph.setGoalNode(endNode);
		graph.setEdgesMap(edges);
		graph.setAdjaceMap(adjacents);
		
		System.out.println("Goal Node"+graph.getGoalNode());
		return graph;
	}
	/**
	 * Method to perform Uniform Cost Search(UCS)
	 * 
	 **/
	public LinkedList<QueueItem> performUCS(String[] nodeList, String[] StartingNode, String[] GoalNode, Map edges, MultiValueMap<String, String> adjacents){
		LinkedList<QueueItem> items = new LinkedList<QueueItem>();
		QueueItem item = new QueueItem();
		int pathCost = 0;
		String goalState = GoalNode[0];
		String[] path = StartingNode;
		item.setPath(path);
		item.setCost(pathCost);
		items.add(item);
		
		for(int i=1;;i++){
			QueueItem firstItem = items.getFirst();
			System.out.println(getCurrentNode(firstItem));
			if(Graph.getAdjacentByNode(getCurrentNode(firstItem), adjacents) != null){
				String[] adjacentNodes = Graph.getAdjacentByNode(getCurrentNode(firstItem), adjacents);
			    items = getUnsortedQueue(adjacentNodes, edges, items);
				items.removeFirst();
			}
			System.out.println("Size of queue "+items.size());
			MyQueue queue = new MyQueue();
			items = queue.sortPriorityQueue(items);
			MyQueue.printTheQueue(items, i);
			if(isTheGoalState(items, goalState)){
				Graph.printOptimalPath(items);
				break;
			}
		}
		return items;
	}
	
	/**
	 * Method to get unsorted Priority Queue
	 * 
	 **/
	public static LinkedList<QueueItem> getUnsortedQueue(String[] adjacentNodes, Map edges, LinkedList<QueueItem> items){
		QueueItem queueitem = new QueueItem();
		queueitem = items.getFirst();
		String currentNode = getCurrentNode(queueitem);
		for(int j = 0; j < adjacentNodes.length; j++){
			int pathCost = 0;
			String[] path = new String[queueitem.getPath().length + 1];
			
		    String[] oldArray = queueitem.getPath();
		    for(int i=0; i < oldArray.length; i++){
		    	path[i] = oldArray[i];
		    }
		    
			if(edges.containsKey(currentNode+"_to_"+adjacentNodes[j])){ 				
				pathCost =  (int) edges.get(currentNode+"_to_"+adjacentNodes[j]) + queueitem.getCost();				
				path[path.length - 1] = adjacentNodes[j];
			}
			QueueItem item = new QueueItem();
			item.setPath(path);
			item.setCost(pathCost);
			items.add(item);
		}
		return items;
	}
	
	/**
	 *  Method to Get the current Node
	 * 
	 **/
	public static String getCurrentNode(QueueItem item){
		String[] pathArray = item.getPath();
		String currentNode = pathArray[pathArray.length - 1];
		return currentNode;
	}
	
	/**
	 *  Method to print the path array
	 * 
	 **/
	public static void printPathArray(String[] path){
		for(int i =0 ; i < path.length; i++){
			if(i == path.length-1){
				System.out.print(path[i]+" ");
			}else{
				System.out.print(path[i]+"->");
			}
			
		}
	}
	
	/**
	 *  Method to goal state test
	 * 
	 **/
	public static boolean isTheGoalState(LinkedList<QueueItem> items, String goalState){
		QueueItem item = items.getFirst();
		String[] path = item.getPath();
		if(goalState.equalsIgnoreCase(path[path.length -1].trim())){
			return true;
		}else{
			return false;
		}
	}
}
