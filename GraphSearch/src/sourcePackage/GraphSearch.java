package sourcePackage;
/**
 * @author imrul
 * Main Method
 * @throws IOException 
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections4.map.MultiValueMap;

public class GraphSearch {

	/**
	 * Main Method..
	 * 
	 */
	public static void main(String[] args) throws IOException{
		while(true){
			GraphSearch search = new GraphSearch();
			Graph graph = new Graph();
			System.out.println("\n");
			System.out.println("Press 1 to Use Mall Map.");
			System.out.println("Press 2 to Entry Other Map. ");
			System.out.println("Press 3 to Terminate the program.");
			Scanner scanner = new Scanner(System.in);
			int check = scanner.nextInt();
			if(check == 1){
				graph = readMallGraphFromFile(graph);
				search.performUCS(graph);
			}else if(check == 1){
				graph = getInputSet();
				search.performUCS(graph);
			}else if(check == 3){
				break;
			}else{
				System.out.println("Incorrect Input");
			}
		}
		System.out.println("Thank you.");
	}
	/**
	 * Method to read Mall graph from file
	 * Get the input set ready
	 * 
	 */
	public static Graph readMallGraphFromFile(Graph graph) throws NumberFormatException, IOException{
		
		String filePath = System.getProperty("user.dir")+"/src/sourcePackage/graph.txt";
		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = null;

		Map<String, Integer> edges = new HashMap<String, Integer>();
		MultiValueMap<String, String> adjacents = new MultiValueMap<String, String>();
		String[] nodeList = new String[88];
		String[] startingNode = new String[1];
		String[] endNode = new String[1];
		int index = 0;
		while((line = reader.readLine())!= null){
			int indexOfOpenBracket = line.indexOf("(");
			int indexOfLastBracket = line.lastIndexOf(")");
//			System.out.println(line);
			line = line.substring(indexOfOpenBracket+1, indexOfLastBracket);
			String[] part = line.split(",");
			String p = part[0];
			int cost = Integer.parseInt(part[1]);
			String[] part1 = p.split("-->");
			String p1 = part1[0];
			String p2 = part1[1];
//			System.out.println(p1+" "+p2+" "+cost);			
			edges.put(part1[0]+"_to_"+part1[1], cost);	
			adjacents.put(p1, p2);
			nodeList[index] = p1;
			index++;
		}
		String[] uniqueNodes = new HashSet<String>(Arrays.asList(nodeList)).toArray(new String[nodeList.length]);
		printUniqueArray(uniqueNodes);
//		System.out.println("edges size"+edges.size());
//		System.out.println("adjacent"+adjacents.size());
		System.out.println("Enter the Current/Starting Node....:");
		startingNode[0] = scanner.next().trim().toUpperCase();
		System.out.println("Enter the Goal/Ending Node....:");
		endNode[0] = scanner.next().trim().toUpperCase();
		
		graph.setNodeList(uniqueNodes);
		graph.setStartingNode(startingNode);
		graph.setGoalNode(endNode);
		graph.setEdgesMap(edges);
		graph.setAdjaceMap(adjacents);
		
		return graph;
	}
	/**
	 * Method to print Node List
	 * 
	 */
	public static void printUniqueArray(String[] nodes){
		System.out.println("\n");
		System.out.println("List of nodes:");
		int index = 1;
		for(String node: nodes){
		 if(node!= null){
			System.out.print(node+",");
			if(index == 10){
				System.out.println("");
				index = 0;
			}
			index++;
		  } 
		}
		System.out.println("\n");
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
			System.out.println("Enter the Name of the node No. "+(i+1)+" ....:");
			nodeList[i] = scanner1.next().trim();
			System.out.println("Enter the number of "+nodeList[i]+"'s neighbour(s) ....:");
			int numberOFneighboursOfI = scanner1.nextInt();
			String[] neighbours = new String[numberOFneighboursOfI];
			int[] pathCostOfNeighbour = new int[numberOFneighboursOfI];
			for(int j = 0; j < numberOFneighboursOfI; j++){
				Scanner scanner2 = new Scanner(System.in);
				System.out.println("Name of the Neighbour No." +(j+1)+" of "+nodeList[i]);
				neighbours[j] = scanner2.next().trim();
				adjacents.put(nodeList[i], neighbours[j]);
				System.out.println("Cost/Distance for "+nodeList[i]+"_to_"+neighbours[j]+" ....:");
				pathCostOfNeighbour[j] = scanner2.nextInt();
				edges.put(nodeList[i]+"_to_"+neighbours[j], pathCostOfNeighbour[j]);
			}	
		}
		System.out.println("Enter the Current/Starting Node....:");
		startingNode[0] = scanner.next().trim().toUpperCase();
		System.out.println("Enter the Goal/Ending Node....:");
		endNode[0] = scanner.next().trim().toUpperCase();
		

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
	public LinkedList<QueueItem> performUCS(Graph graph){
		LinkedList<QueueItem> items = new LinkedList<QueueItem>();
		QueueItem item = new QueueItem();

		int pathCost = 0;
		String[] goalNode = graph.getGoalNode(); 
		String goalState = goalNode[0];
		String[] path = graph.getStartingNode();
		
		item.setPath(path);
		item.setCost(pathCost);
		items.add(item);
		MultiValueMap<String, String> adjacents = graph.getAjaceMap();
		Map<String, Integer> edges = graph.getEdgesMap();
		
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
				Graph.printOptimalPath(items, path[0], goalState);
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
