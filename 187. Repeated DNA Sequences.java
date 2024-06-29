class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        if(s == null || s.length() < 10) return new ArrayList();

        HashMap<String, Integer> map = new HashMap();

        int i = 0, j = 9;

        while(j < s.length())
        {
            String str = s.substring(i, j + 1);
            map.put(str, map.getOrDefault(str, 0) + 1);
            i++;
            j++;
        }

        List<String> result = new ArrayList();

        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > 1) result.add(entry.getKey());
        }

        return result;
    }
}
