/* Time Complexity : O(songs list  + user list) 
// Space Complexity : O(songs to genere list)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Algorithm: Maintain a map between songs to genere since we need to count the number of songs belong to a genre based on the user like's. Then
for each user count the song on which genre the songs belongs to and increment the count accodingly in the count map. Get the max count and if
the genre has the max count add it to the result list.
*/
class Solution {
    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songstogenre = new HashMap<>();                                                 // Map between songs to genre
        Map<String, Integer> count = new HashMap<>();
        for(String genre : genreMap.keySet()){
            for(String song : genreMap.get(genre)){
                        songstogenre.put(song, genre);                                                              // Add it to key value
            }
        }
        for(String s : userMap.keySet()){                                                                                   // For each user
            List<String> gen = new ArrayList<>();
            int max  = 0;
            for(String song : userMap.get(s)){                                                                      // Check the songs
                if(songstogenre.containsKey(song)){                                                                 // If there is a mapping 
                    count.put(songstogenre.get(song), count.getOrDefault(songstogenre.get(song), 0) + 1);               // Get the count
                    max = Math.max(max, songstogenre.get(song));                                                    // Keep the max for each user
                }
            }
            for(String m : counts){
                int val = count.get(m);
                if(val == max){                                                                                     // See which genre has max songs
                    gen.add(val);                                                                       // Add it to the genre list
                }
            }
            res.add(gen);                                                                                       // Add it to the result
            count = new HashMap<>();                                                                                // Reset for the new user
        }
        return res;
    }

}