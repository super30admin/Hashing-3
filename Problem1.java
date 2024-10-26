// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Hashing-3;

public class Problem1 {
    public List<String> findRepeatedDnaSequencesHashing(String s) {
        int n = s.length();
        HashSet<String> allsub = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for(int i = 0; i < n -9;i ++){ //O(n)
            String cur = s.substring(i,i+10);
            if(allsub.contains(cur)){
                //we need subsequence of repeated sequence
                res.add(cur); // creating hashindex for 10 characters
            }else{
                allsub.add(cur); // creating hashing index for 10 characters
            }   
        }
        return new ArrayList<>(res);
    }
}
