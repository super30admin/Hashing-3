// Time Complexity : O(n) n is the length of the string
// Space Complexity : O(n) n for the set to maintain the repeating substring
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// In the given String, start the iteration and save every 10 length substring from the left in a set
// once you encounter the same string in the set, add it to the output, as it is a repeating sequence.
// do this till the length of the string - 10 (till the last 10 characters of the string)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        if(s.length() == 0){
            return new ArrayList<String>();
        }

        HashSet<String> set = new HashSet<>();
        HashSet<String> output = new HashSet<>();

        for(int i = 0; i <= s.length()-10; i++){
            String str = s.substring(i,i+10);

            if(set.contains(str)){
                output.add(str);
            }else{
                set.add(str);
            }
        }

        return new ArrayList<>(output);
    }
}