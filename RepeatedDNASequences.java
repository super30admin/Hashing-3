// Time Complexity : O(N), where N is the length of the string
// Space Complexity : O(N)


//Done using Rabin Karp algorithm


class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 10)
            return new ArrayList<>();
        
        int len = s.length();
        long val = 0;
        int L = 10;
        int base = 13; // choose a prime number
        Set<Long> set = new HashSet<>(); 
        Set<String> res = new HashSet<>();

        for(int i = 0; i < L; i++) {
            char ch = s.charAt(i);
            val = val*base + (ch-'9'); 
        }
        set.add(val);
  
        for(int i = 10; i < len; i++) {        
            val = (long)((val-((s.charAt(i-L)-'9') * Math.pow(base, (L-1))))*base + (s.charAt(i)-'9'));
            if(set.contains(val))
                res.add(s.substring(i-L+1,i+1));
            else
                set.add(val);
        }
        
        return new ArrayList<>(res);
    }
}



