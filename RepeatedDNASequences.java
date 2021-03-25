//TC:O(N)
//SC:O(N)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //count freq of 10-letter-long sequences (substrings) and store it hashmap
        HashMap<String, Integer> map = new HashMap();
        List<String> result = new ArrayList();
        for (int i = 0; i < s.length() - 10 + 1; i++){
           String sequence = s.substring(i, i+10);
           if (!map.containsKey(sequence)){
               map.put(sequence, 1);
           }else{
                int count = map.get(sequence);
                map.put(sequence, ++count);
               // if the freq is 2 ( sequence is repeated more than once), add it to the result
                if (count == 2)
                    result.add(sequence);
               }
          }
        return result;
    }
}
