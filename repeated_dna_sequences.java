class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>(); //base case where if s is null or the length of s is zero, we return an empty arraylist
        HashSet<String> set = new HashSet<>(); //we take a hashset which has the input as String with name set
        HashSet<String> result = new HashSet<>(); //we take a hashset which has the input as String with name result
        for(int i = 0; i <= s.length() - 10; i++) { //we go through all the elements in the String until i <= length of the string because we are checking dna sequences which has the length of 10
            String sub = s.substring(i, i + 10); //we take that substring and assign a string variable to it with name sub
            if(!set.contains(sub)) { //if the set doesnt contains sub
                set.add(sub); //we add the sub to the set
            }
            else { //if the set contains the sub
                result.add(sub); //we add it to the result
            }

        }
        return new ArrayList<>(result); //in the end, we return the result in the form of new arraylist.
    }
}
//tc and sc - O(n)