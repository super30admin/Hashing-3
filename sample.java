class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> hs = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i=0;i<=s.length()-10;i++) {
            String substr = s.substring(i,i+10);
            if (hs.contains(substr)) {
                result.add(substr);
            }
            hs.add(substr);
        }
        return new ArrayList<String>(result);
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        Map<String,List<String>> usersong = new HashMap<>();
        Map<String,List<String>> genresong = new HashMap<>();
        Map<String,List<String>> usergenreresult = new HashMap<>();
        Map<String, String> songgenre = new HashMap<>();
        for (String genre : genresong.keySet() ) {
            List<String> allsongs = genresong.get(genre);
            for (String singlesong:allsongs) {
                songgenre.put(singlesong, genre);
            }
        }
        for (String user: usersong.keySet()) {
            int max=0;
            List<String> songlist = usersong.get(user);
            Map<String, Integer>> genrecount = new HashMap<>();
            for (String song:songlist) {
                String genrename = songgenre.get(song);
                if(!genrecount.containsKey(genrename)) {
                    genrecount.put(genrename, 1);
                } else {
                    genrecount.put(genrename, genrecount.get(genrename)+1);
                }
                max = Math.max(max, genrecount.get(genrename));
            }
            for (String genrenameid : genrecount.keySet()) {
                if (max == genrecount.get(genrenameid)) {
                    if(!usergenreresult.containsKey(user)) {
                        List<String> genrelist = new ArrayList<>();
                        genrelist.add(genrenameid);
                        usergenreresult.put(user, genrelist);
                    } else {
                        usergenreresult.get(user).add(genrenameid);
                    }
                }
            }
            return usergenreresult;
        }

    }
}
