// Time Complexity :O(n(m+k)), where n is users no, m is no of songs and k is genres
// Space Complexity :O(m)

// "static void main" must be defined in a public class.
public class Main {
    
    public static HashMap<String, List<String>> favgenre(HashMap<String, List<String>> userMap, HashMap<String, List<String>> genreMap){
        HashMap <String, String> map = new HashMap<>();
        for(String genre: genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for (String s: songs){
                map.put(s, genre);
            }
        }
        HashMap <String, List<String>> resMap = new HashMap<>();
        HashMap <String, Integer> count;
        for (String user: userMap.keySet()){
            List<String> songs = userMap.get(user);
            count = new HashMap<>();
            int max = 0;
            for (String s: songs){
                String gen = map.get(s);
                int c = count.getOrDefault(gen,0) + 1;
                count.put(gen, c);
                max = Math.max(max, c);
            }
            resMap.put(user, new ArrayList<>());
            for (String gen: count.keySet()){
                if(count.get(gen) == max){
                    resMap.get(user).add(gen);
                }
            }
        }
        return resMap;
    }
    
    public static void main(String[] args) {
        HashMap <String, List<String>> userMap = new HashMap<>();
        HashMap <String, List<String>> genreMap = new HashMap<>();
        userMap.put("David", Arrays.asList(new String[]{"s1","s2","s3","s4","s8"}));
        userMap.put("Emma", Arrays.asList(new String[]{"s5","s6","s7"}));
        genreMap.put("Rock", Arrays.asList(new String[]{"s1","s3"}));
        genreMap.put("Dubstep", Arrays.asList(new String[]{"s7"}));
        genreMap.put("Techno", Arrays.asList(new String[]{"s2","s4"}));
        genreMap.put("Pop", Arrays.asList(new String[]{"s5", "s6"}));
        genreMap.put("Jazz", Arrays.asList(new String[]{"s8", "s9"}));
        HashMap <String, List<String>> res = favgenre(userMap, genreMap);
        System.out.println(res);
    }
}
