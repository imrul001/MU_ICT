/**
 * 
 */
package closurePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;




import org.apache.commons.collections4.map.MultiValueMap;


/**
 * @author imrul
 *
 */
public class Closure {
	public static void main(String[] args){
		System.out.println("Hello Closure");
		MultiValueMap<String, String> dependencies = new MultiValueMap<String, String>();
		String[] attributes = {"A","B","C","D","E","F","G","H","J","K"};
		String[] keys ={"B"};
//		dependencies.put("AB", "C");
//		dependencies.put("A", "DE");
//		dependencies.put("B", "F");
//		dependencies.put("F", "GH");
//		dependencies.put("D", "JK");
		dependencies.put("AB", "D");
		dependencies.put("B", "A");
		dependencies.put("ABC", "D");
		dependencies.put("D", "A");
		dependencies.put("AB", "E");
		dependencies.put("B", "H");
		dependencies.put("ABC", "J");
		dependencies.put("AB", "F");
		dependencies.put("B", "G");
		dependencies.put("ABC", "K");
		dependencies.put("BN", "H");
		dependencies.put("AB", "G");
		System.out.println("main map size "+dependencies.size());
		System.out.println(dependencies);
//		Closure closure = new Closure();
//		closure.printClosure(keys[0], closure.getClouser(keys[0], dependencies));
	}
	
	public String[] getClouser(String attribute, MultiValueMap<String, String> dependencies){
		String[] Closure = createArrayString(attribute);
		System.out.println("map size "+dependencies.size());
		String clo = attribute;
		boolean flag = false;
		for(int i = 0;;i++){
			flag = false;
			
			List<String[]> arrList = new ArrayList<String[]>();
			for(int k=1; k<=3; k++){ //The Limit should be the highest key length of FD
				String[] possibleKey = attributeCombination.AttributeCombination.getAllLists(Closure, k);
				arrList.add(possibleKey);
			}
			for(String[] keyArray : arrList){
				for(int j = 0;j < keyArray.length; j++){
					if(dependencies.containsKey(keyArray[j])){
						String leftSideofFD = keyArray[j].toString();
						String temp =  dependencies.get(leftSideofFD).toString();
						String rightSideofFD = dependencies.get(leftSideofFD).toString().substring(temp.indexOf("[") + 1, temp.lastIndexOf("]"));
						if(containAttributes(leftSideofFD, clo) && !(containAttributes(rightSideofFD, clo))){
//							Closure[0] = Closure[0] + rightSideofFD;
							clo = clo+rightSideofFD;
							flag = true;
						}
					}
				}
			}			
//			System.out.println("closer "+Closure[0]);
			if(!flag){
				break;
			}else{
				Closure = createArrayString(clo);
			}	
		}
		return removeNull(Closure);
	}
	
	public boolean isSubsetOfClosure(String leftSideOfFD, String Closure){
		if(leftSideOfFD.length() > 1){
			return containAttributes(leftSideOfFD, Closure);
		}else{
			return Closure.toLowerCase().contains(leftSideOfFD.toLowerCase());
		}
	}
	
	public boolean containAttributes(String leftOfFD, String Closure){
		boolean flag = true;
		for(int i = 0; i < leftOfFD.length(); i++){
			String temp = Character.toString(leftOfFD.charAt(i));
			if(!Closure.toLowerCase().contains(temp.toLowerCase())){
				flag = false;
				break;
			}else{
				flag = true;
			}
		}
		return flag;
	}
	
	public void printClosure(String Attribute, String closure[]){
		System.out.println("The Closure of "+Attribute);
		for(int i = 0; i< closure.length; i++){
			System.out.print(closure[i]);
		}
	}
	public static String[] removeNull(String[] firstArray){
		List<String> list = new ArrayList<String>();
	    for(String s : firstArray) {
	       if(s != null && s.length() > 0) {
	          list.add(s);
	       }
	    }
	    firstArray = list.toArray(new String[list.size()]);
		return firstArray;
	}
	
	public static String[] createArrayString(String str){
		String[] newString = new String[str.length()];
		for(int i = 0; i<str.length(); i++){
			newString[i] = Character.toString(str.charAt(i));
		}
		return newString;
	}

}



