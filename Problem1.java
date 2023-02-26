/*
The question states that the DNA sequence consists of of only 4 letters A,C,G,T
We need to find repeated substrings in interface

Intuition:

We can have a 10 letter window, and can and store it in hashmap, evertime window slides, we can check in the hashmap for repeatability

Taking hashmap again and again, and taking substrings is an expensive operation

Since our letter can only b 4, we can assign a value to each letter and represent them as a number

A:0, C:1, G:2, T:3

since none of the numebers can be of 4, we can call it our own numeric system of base 4

we will compute the base4 numeric system, and convert it to decimal, on the fly to create hash

We can then keep on creating rolling hash based on the the sliding window roll, and we will be able to create a hash in constant time

Think how we convert a base2 number to a base 10?, the first digit multiply by the 2power len of the (string-1) and subsequently the power keeps on reducing till zero

e.g 101 ---> 1*2^2+0*2^1+1*2^0

We will use the same approach when computing the hash, when a new element comes in we will multiply the prev hash to 4 and add the incoming value
for outgoing value, we will multiply the value with 4pow10 and subtract it from hash 


Time Complexity: O(n)
Space Complexity: O(n)

*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        //edge case when s <1o
        //todo
        if(s.length()<10){
            return result;
        }

        int L=10; // we need to find the 10 digit long numbers, so this would be the size of our window

        int aL = (int)Math.pow(4,L); // the max power of 4 

        HashSet<Integer> seen = new HashSet<Integer>();
         HashSet<Integer> taken = new HashSet<Integer>();

        HashMap<Character,Integer> mapping = new HashMap<Character,Integer>();

        mapping.put('A',0);mapping.put('C',1);mapping.put('G',2);mapping.put('T',3);
        // calculate the hashof First 10 digits
        int currentHash =0;
        for(int i=0;i<=9;i++){
            Character curr = s.charAt(i);
            currentHash = currentHash*4+mapping.get(curr); // adding and converting the number to decimal on the fly a
        }

        seen.add(currentHash);// since we have already seen this hash, so adding it to the hash

        for(int i=1;i<s.length()-9;i++){ // stop atleast 10 indices early
        char out = s.charAt(i-1);
        char in = s.charAt(i+9);


        // adding the in value
        currentHash= currentHash * 4 + mapping.get(in);

        // Subtracting the out value

        currentHash = currentHash - mapping.get(out) * aL;

        // check if the new hash already seen

        if(seen.contains(currentHash) && !taken.contains(currentHash)){
            result.add(s.substring(i,i+10));
            taken.add(currentHash);
        }
        else{
            seen.add(currentHash); // add it for the next time
        }

        }

        return result;
    }
}