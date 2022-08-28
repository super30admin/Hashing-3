//TC - O(n)
//SC - O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> allStr = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for(int i = 0; i <= s.length() - 10; i++){
            String sub = s.substring(i, i + 10);
            
            if(allStr.contains(sub)){
                result.add(sub);
            }
            allStr.add(sub);
        }
        return new ArrayList<>(result);
    }
}
