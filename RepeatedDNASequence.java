package Hashing3;

public class RepeatedDNASequence {
	//TC : o(n)
	//SC : o(n)
	//Approach : use sliding window for window 10 using 2 hashsets. 1 set for result and 1 for storing repeated strings to avoid duplicates
	class Solution {
	    public List<String> findRepeatedDnaSequences(String s) {
	        //null check
	        HashSet<String> allSubStrings = new HashSet<>();
	        HashSet<String> result = new HashSet<>();
	        //window 10
	        for(int i=0 ;i<s.length()-9; i++){
	            String subString = s.substring(i, i+10);
	            if(allSubStrings.contains(subString)){
	                result.add(subString);
	            }
	            allSubStrings.add(subString);
	        }
	        return new ArrayList<>(result);
	    }
	}
}
