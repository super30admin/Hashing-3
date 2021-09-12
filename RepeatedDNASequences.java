// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for(int i = 0; i < s.length() - 9; i++){
            String seq = s.substring(i, i + 10);
            if(set.contains(seq)){
                result.add(seq);
            }
            else{
                set.add(seq);
            }
        }
        return new ArrayList<>(result);
    }
}