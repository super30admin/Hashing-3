//TimeComplexity:O(10n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for(int i =0; i<=s.length()-10;i++) {
            String substr = s.substring(i, i+10);
            if(set.contains(substr)) {
                result.add(substr);
            } else {
                set.add(substr);
            }
        }
        return new ArrayList<>(result);
    }
}