// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Long> allSubs = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',1);map.put('C',2);map.put('G',3);map.put('T',4);
        HashSet<String> res = new HashSet<>();
        long kl = (long)Math.pow(4,9);
        long hash = 0l;
        for(int i = 0; i < s.length(); i++){
            if(i >= 10){
                char out = s.charAt(i-10);
                hash = hash - kl*map.get(out);
            }
            char in = s.charAt(i);
            hash = hash*4 + map.get(in);
            if(allSubs.contains(hash)){
                res.add(s.substring(i-9,i+1));
            }
            else
                allSubs.add(hash);
        }
        return new ArrayList<>(res);
    }
}