//Time - O(n)
//Space - O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> allHashSets = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for(int i=0; i<=s.length()-10; i++){
            String subStr = s.substring(i,i+10);
            if(!allHashSets.contains(subStr)){
                allHashSets.add(subStr);
            }else{
                result.add(subStr);
            }
        }
        return new ArrayList<>(result);
    }
}