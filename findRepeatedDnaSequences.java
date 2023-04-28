//Time Complexity : O(N*N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * iterate over each substring and check if it is in seen list. If so, add it to
 * result list else ignore. Then add it to the seen list. finally return result
 * list.
 *
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> subStrings = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String sub = s.substring(i,i+10);
            if(subStrings.contains(sub)){
                result.add(sub);
            }else{
                subStrings.add(sub);
            }
;        }
        return new ArrayList<>(result);
    }
}
