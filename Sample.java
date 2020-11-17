//Repeated DNA sequence
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hashset= new HashSet<>();
        HashSet<String> output= new HashSet<>();
        for(int i=0;i<=s.length()-10;i++)
        {
            String sub= s.substring(i,i+10);
            if(hashset.contains(sub))
            {
                output.add(sub);
            }
            else
                hashset.add(sub);
        }
        return new ArrayList<>(output);
    }
}
