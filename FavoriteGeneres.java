

/**
 * Maps each song to its genre and counts genre frequency for each user.
 * Identifies the user's favorite genres by tracking maximum frequency.
 * Returns a mapping of users to their list of favorite genres.
 */
// Time Complexity: O(U * S), where U = number of users and S = average number of songs per user
// Space Complexity: O(G + S), where G = total genres and S = total songs
public class FavoriteGeneres {
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        
        HashMap<String, String> songToGenreMap = new HashMap<>();
        
        for(String genre : genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(String song : songs){
                songToGenreMap.put(song, genre);
            }
        }
        
        HashMap<String, List<String>> result = new HashMap<>();
        
        for(String user : userMap.keySet()){
            result.put(user, new ArrayList<>());
            List<String> songs = userMap.get(user);
            HashMap<String, Integer> frqMap = new HashMap<>();
            int max = 0;
            
            for(String song : songs){
                String genre = songToGenreMap.get(song);
                frqMap.put(genre, frqMap.getOrDefault(genre, 0)+1);
                
                if(max < frqMap.get(genre)){
                    result.get(user).clear();
                    result.get(user).add(genre);
                }else if(max == frqMap.get(genre)){
                     result.get(user).add(genre);
                }
                max = Math.max(max, frqMap.get(genre));
            }
        }
        
        return result;
    }
    
}
