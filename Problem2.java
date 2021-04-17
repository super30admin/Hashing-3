//time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> seen = new HashMap();
        List<String> ans= new ArrayList<>();
        
        for(int i=0;i+9<s.length();i++){
            String out=s.substring(i,i+10);
            seen.put(out,seen.getOrDefault(out,0)+1);
            if(seen.get(out)==2)//if any repeating elements only seen twice we will add that to output
                ans.add(out);
            
        }
        return ans;
    }
}