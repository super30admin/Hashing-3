// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        if(s.length() < 11) return new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        HashSet<Long> set = new HashSet<>();
        long hash = 0;
        //Go through all the char in string
        for(int i=0; i<s.length(); i++){
            //Calculate hash
            if(i > 9){
                char out = s.charAt(i-10);
                int o = map.get(out);
                hash = hash - (o * (long)Math.pow(4, 9));
            }

            char in = s.charAt(i);
            int inn = map.get(in);
            hash = (hash * 4) + inn;

            //if hash matches with previos hash, add the string to result
            if(i > 8){
                if(set.contains(hash)){
                    result.add(s.substring(i-9, i+1));
                } else{
                    set.add(hash);
                }
            }
        }

        return new ArrayList<>(result);
    }
}