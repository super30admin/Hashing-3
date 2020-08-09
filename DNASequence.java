//time o(n)
//space o(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length()==0) 
            return new ArrayList<>();
        
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length()-10+1; i++) {
            String temp = s.substring(i, i+10);
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        
        for(String key : map.keySet()) {
            if(map.get(key)>1) {
                res.add(key);
            }
        }
        return res;
    }
}