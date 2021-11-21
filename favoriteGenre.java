// Time Complexity : O( max(songs, genre)
// Space Complexity : O(songs)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution{
    public static Map<String, List<String>> favoriteGenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap){
        
        HashMap<String, List<String>> result = new HashMap<>();
        HashMap<String, String> songsToGenre = new HashMap<>();
        
        for(String genre: genreap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(string song: songs){
                songsToGenre.put(song, genre);
            }
        }
        
        HashMap<String, String> countMap = new HashMap<>();
        for(String user: userMap.keySet()){
            result.put(user, new ArrayList<>());
            countMap  new HashMap<>();
            int maxCount = 0;
            
            List<String> songs = userMap.get(user);
            for(String song: songs){
                String genre = songsToGenre.get(song);
                countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                maxCount = Math.max(maxCount, countMap.get(genre));
            }
            for(String genre: countMap.keySet()){
                if(countMap.get(genre) == maxCount){
                    // add to resultant list
                    result.get(user).add(genre);
                }
            }
            return result;
        }
        
    }
    
}