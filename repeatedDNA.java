//Time Complexity: O(N)
//Space Complexity: O(N)
//Keep a hashmap to keep track of the substrings of 10 and their counts to mark it as viewed
//A resultant list to return the repeated substrings in the DNA sequence.
//iterate over the sequence by checking for every substring of length 10 as long as it is <= the length of the DNA sequence
//Store the substring from i to i+10 in a variable and put in the hashmap and increment its count by 1 to mark howmany times viewed
// if the substring was viewed twice this it is a repeated substring and must be added to the repeated List
//Return the repeated list as result.  
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> repeated = new ArrayList<>();
        Map<String, Integer> viewed = new HashMap<>();
        int i=0;
        while(i+10 <= s.length())
        {
            String sub = s.substring(i,i++ + 10);
            viewed.put(sub, viewed.getOrDefault(sub,0)+1);
            if(viewed.get(sub)==2)
            {
                repeated.add(sub);
            }
        }
        return repeated;
    }
}