package sourcePackage;

import java.util.Arrays;

public class QueueItem implements Comparable<QueueItem>{
	
	private String[] path;
	private int cost;
	
	@Override
	public int compareTo(QueueItem qi){
		int comparedCost = qi.cost;
		if(this.cost > comparedCost){
				return 1;
		}else if(this.cost == comparedCost){
			return 0;
		}else{
			return -1;
		}
	}
	
	public String[] getPath(){
		return Arrays.copyOf(path, path.length);
	}
	
	public void setPath(String[] path){
		this.path = Arrays.copyOf(path, path.length);
	}
	
	public int getCost(){
		return this.cost;
	}
	
	public void setCost(int Cost){
		this.cost = Cost;
	}
}
