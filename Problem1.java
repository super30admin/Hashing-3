// Time Complexity - O(n) where n is the length of s
// Space Complexity - O(n) where n is the length of s
// This solution worked on LeetCode


class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> allsubs = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for(int i=0;i <= s.length()-10;i++){
            String sub = s.substring(i,i+10);
            if(allsubs.contains(sub)){
                result.add(sub);
            }
            else{
                allsubs.add(sub);
            }
        }
        return new ArrayList<>(result);
    }  
}
