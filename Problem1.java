

//Time Complexity: O(N)
//Space Complexity: O(N)

//We can use a HashSet to store the substrings of length 10 as we iterate through the string.
//If we encounter a substring that is already in the set, we add it to another set that keeps 
//track of repeated substrings. Finally, we convert the set of repeated substrings to a list and return it.

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set=new HashSet<>();
        HashSet<String> ans=new HashSet<>();
        for(int i=0;i<s.length()-9;i++){
            String substr=s.substring(i,i+10);
            if(!set.contains(substr))
                set.add(substr);
            else
                ans.add(substr);
        }
        return new ArrayList<>(ans);
    }
}