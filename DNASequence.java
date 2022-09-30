//Using HashMap 

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        
        if(s.length() == 0 || s == null)
            return res;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i <= s.length() - 10; i++){
            String sub = s.substring(i, i+10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        
        for(String st : map.keySet()){
            if(map.get(st) > 1)
                res.add(st);
        }
        return res;
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n)