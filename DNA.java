//time complexity O(n)
//space complexity O(2n) size of two hashmaps

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        int count = 0;
        for(int i = 0; i <= s.length() - 10; i++){
            String sub = s.substring(i, i+10);
            if(set.contains(sub)){
                result.add(sub);
            }
            set.add(sub);
        }
        List<String> list = new ArrayList<String>(result);
        return list;
    }
}
