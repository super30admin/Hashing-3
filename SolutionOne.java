// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

class SolutionOne {
    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> allSubs = new HashSet<>();

        HashSet<String> result = new HashSet<>();

        for(int i=0;i<s.length()-9;i++)
        {
            String sub = s.substring(i,i+10);

            if(allSubs.contains(sub))
            {

                result.add(sub);
            }

            allSubs.add(sub);

        }

        return new ArrayList<String>(result);
    }
}