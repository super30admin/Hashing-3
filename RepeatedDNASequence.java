//Time Complexity - O(n)
//Space Complexity - O(n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        HashSet<String> addSequence = new HashSet<>();
        for(int i = 0; i <= s.length() - 10; i++){
            String t = s.substring(i, i+10);
            if(addSequence.contains(t)){
                result.add(t);
            }
            addSequence.add(t);
        }
        return new ArrayList<String>(result);
        
    }
}