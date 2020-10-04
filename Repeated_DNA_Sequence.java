import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        //edge case
        if(s == null || s.length() == 0)
            return list;
        for(int i=0; i <= s.length()-10;i++)
        {
            String sub = s.substring(i, i+10);
            
            map.put(sub, map.getOrDefault(sub,0)+1);
        }
        for(String str : map.keySet())
        {
            
            int val = map.get(str);
          //  System.out.println(str + "--"+val);
            if(val > 1)
                list.add(str);
        }
        return list;
    }
}

//Time complexity: O(n)
//Space complexity : O(n)