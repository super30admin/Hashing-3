class Solution {
    public List findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        int i=0;
        List<String> ans = new ArrayList<>();
        while(i<=s.length()-10){
        String a= s.substring(i,i+10);
        if(set.contains(a)){
            if(!ans.contains(a))
             ans.add(a);
            }
            else{
            set.add(a);
            }
            i++;
        }
        return ans;
    }
}
