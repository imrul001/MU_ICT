package sourcePackage;

import java.util.Collections;
import java.util.LinkedList;


public class MyQueue {
	
	/**
	 * Method to Generate Queue
	 * 
	 **/
	public LinkedList<QueueItem> generateQueue(int[] cost, String[] name){
		LinkedList<QueueItem> queue = new LinkedList<QueueItem>();
		for(int i=0; i<cost.length; i++){
			QueueItem item = new QueueItem();
			item.setCost(cost[i]);
			item.setPath(name);
			queue.add(item);
		}
		return queue;
	}
	
	/**
	 * Method to sort Priority Queue 
	 * 
	 **/
	public LinkedList<QueueItem> sortPriorityQueue(LinkedList<QueueItem> items){
		LinkedList<QueueItem> sortedList = items;
		Collections.sort(sortedList);
		return sortedList;
	}
	/**
	 * Method to print Priority Queue
	 * 
	 **/
	public static void printTheQueue(LinkedList<QueueItem> items, int iterationNo){
		System.out.println("Iteration No "+iterationNo);
		for(QueueItem item : items){
			GraphSearch.printPathArray(item.getPath());
			System.out.print("{Cost=");
			System.out.print(item.getCost());
			System.out.print("}");
			System.out.println(" ");
		}
		System.out.println();		
	}
	
}
