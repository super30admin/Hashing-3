class Solution {

    //Time Complexity: 0(n) //where n is the Length of string
    //Space Complexity: 0(n)

    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }

        HashSet <String> set = new HashSet<>(); //I use a hashset to store all the unique substring of dna sequence I come across
        HashSet <String> result = new HashSet<>();  //a hashset to store the repeating dna sequence

        for(int i = 0; i <= s.length() - 10; i++){  //starts from 0 and goes up to length - 1 as I am taking a substring of 10characters
            String a = s.substring(i, i+10);    //i am taking a substring of 10characters in the sequence
            if(set.contains(a)){    //if the substring is already seen, I add it to my result
                result.add(a);
            }
            set.add(a); //I add every substring to my hashset
        }
        return new ArrayList<>(result);
    }
}