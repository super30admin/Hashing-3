//TC : O(N) - length of the string
//SC : O(N) - Creating HashSet 

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> input = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        
        
        for(int i = 0; i<= s.length() - 10; i++){
            String temp = s.substring(i, i + 10); // Creating substring of size 10
            if(input.contains(temp))
                result.add(temp);
            
            input.add(temp);
        }
        return new ArrayList<>(result);
    }
}