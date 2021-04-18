// Time Complexity : O(n)
// Space Complexity : O(m) where m is total no of sequences 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		if(s == null || s.length() < 10) {
			return Collections.emptyList();
		}
		int start = 0;
		int end = 10;
		Set<String> set = new HashSet<>();
		Set<String> result = new HashSet<>();
		StringBuilder builder = new StringBuilder(s);
		while(end <= s.length()) {            
			//String curr = s.substring(start,end);   
			//builder is faster, so using builder below
			String curr = builder.substring(start,end);   
			if(set.contains(curr)) {
				result.add(curr);
			}
			set.add(curr);
			start++;
			end++;
		}
		return new ArrayList<>(result);
	}
}
