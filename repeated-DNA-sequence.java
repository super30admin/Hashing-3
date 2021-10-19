//TC: O(n), taking substrings of length 10 for n elements, so its 10n
//SC: O(n)
//running on leetcode: yes
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s==null || s.length()==0) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for(int i = 0; i<s.length()-9; i++){
            String sub = s.substring(i, i+10);
            if(set.contains(sub)) {
                result.add(sub);
            }
            set.add(sub);
        }
        return new ArrayList<>(result);
    }
}
