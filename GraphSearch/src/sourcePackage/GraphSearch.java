package sourcePackage;

import java.util.HashMap;

import java.util.LinkedList;
import java.util.Map;

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
		search.performUCS(nodeList, startingNode, goalNode, edges, adjacents);
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
			String[] adjacentNodes = Graph.getAdjacentByNode(getCurrentNode(firstItem), adjacents);
			items = getUnsortedQueue(adjacentNodes, edges, items);				
			items.removeFirst();
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
		if(path[path.length -1] == goalState){
			return true;
		}else{
			return false;
		}
	}
}
