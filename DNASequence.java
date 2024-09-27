/*
The time complexity is O(N-L) where N is the length of the string s and L is the length of matching sequence. In this case it is 10.
The space complexity is also O(N-L).

Here we encode each character into its corresponding integers. Since we can just hava 4 characters we can use 0,1,2,3. Then we calculate
the encoded int of first 10 characters. Then for each character starting from index 1 we remove the previous window character number
and add the present window character number. If this is already seen add the 10 length string to the output hashset.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        int len = s.length();
        if(len<10){return new ArrayList<>();}
        HashMap<Character,Integer> dna = new HashMap<>();
        dna.put('A',0); dna.put('C',1); dna.put('G',2); dna.put('T',3);

        int[] sarray = new int[len];

        //Encode each character to its corresponding number
        for(int i=0;i<len;i++){
            sarray[i] = dna.get(s.charAt(i));
        }

        Set<Integer> hash = new HashSet<>();
        Set<String> output = new HashSet<>();


        //Calculate bitmast for the first 10 characters.
        int bitmask = 0;
        for(int i=0;i<10;i++){
            bitmask <<= 2;
            bitmask |= sarray[i];
        }

        hash.add(bitmask);


        for(int i=1;i<=len-10;i++){

            bitmask <<= 2;

            //Add the new character number
            bitmask |= sarray[i+10-1];

            //Remove the pervious character number
            bitmask &= ~(3<< 2*10);

            //Check if this is already seen
            if(hash.contains(bitmask)){
                output.add(s.substring(i,i+10));
            }

            hash.add(bitmask);
        }

        return new ArrayList<>(output);
    }
}