class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        HashSet<String> subStrings = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        
        for(int i = 0; i <= s.length() - 10; i++){
            String sub = s.substring(i, i+10);
            if(subStrings.contains(sub)){
                result.add(sub);
            }
            subStrings.add(sub);
        }
        return new ArrayList<>(result);
    }
}

//TC: O(n)
//SC: O(2n) // 2 hashsets.
