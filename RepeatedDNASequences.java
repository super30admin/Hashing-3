// 187.
// time - O(n)
// space - O(n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> allSubStrings = new HashSet<>(); //set tracks all 10 unit length substrings
        HashSet<String> repeatedSubStrings = new HashSet<>(); //return list
        
        //edge
        if(s == null || s.length() == 0)
        {
            return new ArrayList<>(); //empty list
        }
        
        for(int i = 0; i <= s.length() - 10; i++)
        {
            String current = s.substring(i, i + 10); //get the current substring
            //if current was seen earlier add current to result else add it to allSubStrings which is a set of all substrings 
            if(allSubStrings.contains(current)) 
            {
                repeatedSubStrings.add(current);
            }
            allSubStrings.add(current);
        }
        
        return new ArrayList<>(repeatedSubStrings);
    }
}
