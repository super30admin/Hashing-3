//TC : O(n)
//SC : O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> hs = new HashSet();
        HashSet<String> result = new HashSet();

        for(int i=0;i<=s.length()-10;i++)
        {
            String subString = s.substring(i,i+10);
            if(hs.contains(subString))
                result.add(subString);

            hs.add(subString);
        }
        return new ArrayList(result);
    }
}