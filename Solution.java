
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :NO

/*
Approach
we are using 2 hashmap to calculate the favgenre of all the users
*/
public class Solution {

    public HashMap<String,String> favgen(HashMap<String,List<String>> genreMap){
        HashMap<String,String> songToGenre = new HashMap<>();
        HasMap<String,String> result = new HashMap<>();
        for(String genre: genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(String song:songs){
                songToGenre.put(song,genre);
            }
        }
        HashMap<String,Integer> countMap;
        for(String users:userMap.keySet()){
            result.put(user,new ArrayList<>());
            countMap  = new HashMap<>();
            List<String> songs = userMap.get(user);
            for(String song: songs){
                String genre = songToGenre.get(song);
                countMap.put(genre,countMap.getOrDefault(genre,0)+1);
                max = Math.max(max,countMap.get(genre));
                for(String genre: countMap.keySet()){
                    if(countMap.get(genre) == max){
                        result.get(user).add(genre);
                    }
                }
            }
        }
        return result
    }
}
