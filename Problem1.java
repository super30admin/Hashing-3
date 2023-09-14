public class Problem1 {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10) return new ArrayList<>();
        int h = 0, k = 4;
        HashSet<Integer> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        for (int i=0;i<10;i++) {
            char c = s.charAt(i);
            h = h*k+map.get(c);
        }

        set.add(h);
        for (int i=10;i<s.length();i++) {
            char out = s.charAt(i-10);
            char in = s.charAt(i);

            h = h*k+map.get(in);
            h = h - (int)(Math.pow(k,10)*map.get(out));

            if (set.contains(h)) res.add(s.substring(i-9,i+1));
            else set.add(h);
        }

        return new ArrayList<>(res);
    }