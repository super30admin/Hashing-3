//Time complexity: O(n)
//Space Complexity: O(n)
//Did it run on leetcode: yes

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> output = new ArrayList<>();
        
        for(int i=0; i<=s.length()-10; i++){
            String sub = s.substring(i, i+10);
            map.put(sub, map.getOrDefault(sub, 0)+1);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1)
                output.add(entry.getKey());
        }
        
        return output;
    }
}
