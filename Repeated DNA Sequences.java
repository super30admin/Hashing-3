//Time Complexity-O(n)
//Space Complexity-O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer>map=new HashMap();
        List<String>output=new ArrayList();
        for(int i=0;i<=s.length()-10;i++)
        {
            String subString=s.substring(i,i+10);            
            map.put(subString,map.getOrDefault(subString,0)+1);
        } 
        for(String key:map.keySet())
        {
            if(map.get(key)>1)
            {
                output.add(key);
            }
        }
        return output;
    }
}