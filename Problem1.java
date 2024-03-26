class Solution {
    //TC: O(10n)
    //SC: O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() == 0 || s == null)  return new ArrayList<>();
        HashSet<String> allSubs = new HashSet<>();
        int n = s.length();
        HashSet<String> result = new HashSet<>();
        for(int i = 0; i <= n-10; i++){
            String sub = s.substring(i,i+10);
            if(allSubs.contains(sub)){
                result.add(sub);
            }else{
               allSubs.add(sub);

            }
        }
        return new ArrayList<>(result);
    }
}
