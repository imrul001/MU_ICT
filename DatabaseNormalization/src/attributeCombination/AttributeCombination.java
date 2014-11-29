/**
 * 
 */
package attributeCombination;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.map.MultiValueMap;

/**
 * @author imrul
 *
 */
public class AttributeCombination {
	
	public static void main(String[] args){
		String[] arr = {"A","B","C"};
		List<String[]> arrList = new ArrayList<String[]>();
		for(int i = 0;i <arr.length; i++){
			String[] pKeyList = getAllLists(arr, i+1);
			arrList.add(pKeyList);
		}
		
		for(String[] keyList: arrList){
			for(int k=0; k<keyList.length; k++){
				System.out.println(k+" "+keyList[k]);
			}
		}
		MultiValueMap<String, String> dependencies = new MultiValueMap<String, String>();
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
		//String[] result =getAllLists(arr, 1);
//		for(int i = 0; i < result.length; i++){
//			System.out.println(i+" "+result[i]);
//		}
//		for(int i = 1; i<= arr.length ; i++){
//			String[] result =getAllLists(arr, i);
//			String[] main = ArrayUtils.addAll(result,)
//			
//			
//		}
//		for(int i = 0; i < result.length; i++){
//			System.out.println(i+" "+result1[i]);
//		}

	}
	public static void combinations(String s, int n) {
	    combinations(s, "", n);
	}

	public static void combinations(String s, String prfx, int n) {
	    if (n == 0) {
	        System.out.println(prfx);
	    }

	    else {
	        for (int i = 0; i < s.length(); i++) {
	            combinations(s, prfx + s.charAt(i), n - 1);
	        }
	    }
	}
	public static String[] getAllLists(String[] elements, int lengthOfList)
	{
	    //initialize our returned list with the number of elements calculated above
	    String[] allLists = new String[(int)Math.pow(elements.length, lengthOfList)];

	    //lists of length 1 are just the original elements
	    if(lengthOfList == 1) return elements; 
	    else
	    {
	        //the recursion--get all lists of length 3, length 2, all the way up to 1
	        String[] allSublists = getAllLists(elements, lengthOfList - 1);

	        //append the sublists to each element
	        int arrayIndex = 0;

	        for(int i = 0; i < elements.length; i++)
	        {
	            for(int j = 0; j < allSublists.length; j++)
	            {
	                //add the newly appended combination to the list
	                allLists[arrayIndex] = elements[i] + allSublists[j];
	                arrayIndex++;
	            }
	        }

	        return allLists;
	    }
	}

}
