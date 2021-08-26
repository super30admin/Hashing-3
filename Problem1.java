// Time - O(N)
// Space - O(N)


class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> allSub = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        for(int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i,i+10);

            if(allSub.contains(sub)){
                result.add(sub);
            }
            allSub.add(sub);

        }

        return new ArrayList<>(result);

    }
}