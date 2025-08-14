// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Use rolling hash computation methoUse sliding window to iterate through subseqeucnes of length 10. For each
/// such subsequence compute the hash by mapping A-> 1, C->2, G->3, T->4 and a const, say 4, for power. Store these hashes in
/// set. If same hash occurs again, that's a repeated subsequence
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        HashSet<Integer> substrings = new HashSet<>();
        int hash = 0;
        int p = (int)Math.pow(4, 9);
        for(int i=0;i<n;i++){
            if(i>=10){
                char out = s.charAt(i-10);
                hash = hash - p*map.get(out);
            }
            char in = s.charAt(i);
            hash = hash* 4 +map.get(in);
            if(!substrings.contains(hash)){
                substrings.add(hash);
            }
            else{
                result.add(s.substring(i-9, i+1));
            }
        }
        return new ArrayList<String>(result);
    }
}