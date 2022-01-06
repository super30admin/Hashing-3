//Timecomplexity:- O(n+m) m is for iterating hasmap of repeated substrings.
//space complexity:- 0(m)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> output=new ArrayList<>();
        HashMap<String,Integer> cache=new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String str=s.substring(i,i+10);
            int count=cache.getOrDefault(str,0); // by the idea of sliding window appending hashmap
            cache.put(str,count+1);
            
        }
        for(String required:cache.keySet()){
            if(cache.get(required)>1){
                output.add(required); //iterating over hashmap keys which are are repeated more than once.
            }
        }
        return output;
    }
}