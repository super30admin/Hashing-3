//Time Complexity: O(n)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem1 {

    public List<String> findRepeatedDnaSequences(String s) {
        
        if(s == null|| s.length() <= 10)
            return new ArrayList<>();
        
        HashSet<String> set = new HashSet<>();
        HashSet<String> answer = new HashSet<>();
        
        for(int i =0; i <= s.length() - 10; i++)
        {
            String sub = s.substring(i, i+10);
            
            if(set.contains(sub))
                answer.add(sub);
            
            set.add(sub);
        }
        
        return new ArrayList<>(answer);
    }
}
