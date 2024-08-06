//Time Complexity : O(n)
//Space Complexity : O(1)
class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        HashSet<Long> seq = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        long hash = 0l;
        long posFactor = (long)Math.pow(4, 10);

        for(int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            hash = hash*4+map.get(in);

            if(i >= 10) {
                char out = s.charAt(i-10);
                hash = hash - map.get(out) * posFactor;

            }
            if(!seq.contains(hash)) {
                seq.add(hash);
            } else {
                res.add(s.substring(i-9,i+1));
            }
        }
        return new ArrayList<>(res);
    }
}