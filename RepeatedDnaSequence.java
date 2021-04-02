// Time Complexity : O(N-L)*O(L), N-L positions to evaluate in string, O(L) to compute substring
// Space Complexity : O((N-L)*L), storing result in set, N-L results in worst case, of length L 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// use rolling hash to compute if substring already seen or not, if seen add to result

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s==null || s.length()<=10)
            return new ArrayList<String>();
        
        int base = 4; //A,C,G,T
        HashMap<Character, Integer> encoding = new HashMap(){
            {
                put('A', 3);
                put('C', 2);
                put('G', 1);
                put('T', 0);                
            }
        };
        
        HashSet<Integer> seen = new HashSet();
        int rollingHash = 0;
        
        for(int i=0; i<10; i++){
            rollingHash = rollingHash*base + encoding.get(s.charAt(i));
        }
        seen.add(rollingHash);
        
        Set<String> resultSet = new HashSet();
        for(int i=1; i<s.length()-10+1; i++){
            rollingHash -= encoding.get(s.charAt(i-1))*Math.pow(base, 9);
            rollingHash = rollingHash*base + encoding.get(s.charAt(i+10-1));
            
            if(seen.contains(rollingHash))
                resultSet.add(s.substring(i, i+10));
            
            seen.add(rollingHash);
        }
        
        return new ArrayList<String>(resultSet);
    }
}