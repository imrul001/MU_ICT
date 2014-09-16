package sourcePackage;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.MultiValueMap;


public class Graph {
	
	private int nubmberOFnodes;
	private String[] nodeList;
	private String[] startingNode;
	private String[] goalNode;
	private Map<String, Integer> edges;
	private MultiValueMap<String, String> adjacents;
	
	public String[] getNodeList(){
		return Arrays.copyOf(nodeList, nodeList.length);
	}
	
	public void setNodeList(String[] nList){
		this.nodeList = Arrays.copyOf(nList, nList.length);
	}
	
	public String[] getStartingNode(){
		return Arrays.copyOf(startingNode, startingNode.length);
	}
	
	public void setStartingNode(String[] startNode){
		this.startingNode = Arrays.copyOf(startNode, startNode.length);
	}
	
	public String[] getGoalNode(){
		return Arrays.copyOf(goalNode, goalNode.length);
	}
	
	public void setGoalNode(String[] gNode){
		this.goalNode = Arrays.copyOf(gNode, gNode.length);
	}
	
	public Map<String, Integer> getEdgesMap(){
		return this.edges;
	}
	
	public void setEdgesMap(Map<String, Integer> edgesMap){
		this.edges = edgesMap;
	}
	
    public MultiValueMap<String, String> getAjaceMap(){
    	return this.adjacents;
    }
    
    public void setAdjaceMap(MultiValueMap<String, String> adjacentMap){
    	this.adjacents = adjacentMap;
    }
    
    public int getNumberOfNodes(){
    	return this.nubmberOFnodes;
    }
    
    public void setNumberOfNodes(int nOFnodes){
    	this.nubmberOFnodes = nOFnodes;
    }	
	
	
	
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
