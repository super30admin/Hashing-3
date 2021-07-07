//time o(usermap count) + o(genreMap count)
//space o(usermap count)
class Solution {
    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        HashMap<String, String> songToGenre = new HashMap<>();
        HashMap<String, List<String>> result = new HashMap<>();
        
        //iterate over the genre to songs map to fill the songToGenre map
        for(String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for(String song : songs) {
                songToGenre.put(song, genre);
            }
        }
        
        //maintain a genre to count map for every user
        HashMap<String, Integer> genreToCount;
        for(String user: userMap.keySet()) {
            List<String> songs = userMap.get(user);
            int max = 0;
            genreToCount = new HashMap<>();
            result.put(user, new ArrayList<>());
            for(String song : songs) {
                String genre = songToGenre.get(song);
                genreToCount.put(genre, genreToCount.getOrDefault(genre, 0)+1);
                max = Math.max(max, genreToCount.get(genre));
            }
            for(String genre : genreToCount.keySet()) {
                if(genreToCount.get(genre) == max) {
                    result.get(user).add(genre);
                }
            }
        }
        return result;
    }

} 