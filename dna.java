class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> substrings = new HashSet<>(); 
        HashSet<String> result = new HashSet<>(); 
        for(int i=0;i<=s.length()-10;i++){
            String curr = s.substring(i,i+10);
            if(substrings.contains(curr)) result.add(curr);
            substrings.add(curr);
        }
    return new ArrayList<>(result);
   }
}