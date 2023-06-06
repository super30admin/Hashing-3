//Time complexity - O(nk)
//Space Complexity - O(1)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n < 10)
            return new ArrayList<>();
        HashSet<String> result = new HashSet<>();
        HashSet<Integer> seen = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        int hash = 0;
        for(int i = 0; i < n; i++){
            char in = s.charAt(i);
            hash = hash * 4 + map.get(in);
            if(i > 9){
                char out = s.charAt(i - 10);
                hash = hash - map.get(out) * (int)Math.pow(4, 10);
            }
            if(seen.contains(hash)){
                result.add(s.substring(i-9, i+1));
            }
            seen.add(hash);
        }
        return new ArrayList<>(result);
    }
}
