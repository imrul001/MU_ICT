package sourcePackage;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.map.MultiValueMap;


public class Graph {
	
	/**
	 * Method to get Adjacent Nodes by Current Node  
	 * 
	 **/
	public static String[] getAdjacentByNode(String node, MultiValueMap<String, String> adjacents){
		String searchKey = node;
		List<String> list = (List<String>)adjacents.get(searchKey);
		String[] p = new String[list.size()];
		for(int i = 0; i < list.size(); i++){
			p[i] = list.get(i);	
		}
		return p;
	}
	/**
	 * Method to printResult
	 * 
	 **/
	public static void printOptimalPath(LinkedList<QueueItem> items){
		QueueItem item = items.getFirst();
		String[] path = item.getPath();
		System.out.println("");
		System.out.println("The optimal path is");
		for(int i=0;i<=path.length-1;i++){
			if(i==path.length-1){
				System.out.print(path[i]);
			}else{
				System.out.print(path[i]+"===>");				
			}
		}
		System.out.println("");
		System.out.println("And the cost is "+item.getCost());
	}
	
	

}
