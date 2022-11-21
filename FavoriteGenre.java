// Time Complexity : O(mn)
// Space Complexity : O(n+k) ~= O(n)
// m is the number of users , n is the number of songs , k is the number of genre (genre can never be greater than songs)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class Main {
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        HashMap<String,String> sgMap = new HashMap<>();
        HashMap<String,Integer> countMap; // not initializign here because we re-use it for all users
        HashMap<String,List<String>> result = new HashMap<>();

        //Make songs to genre map
        for(String genre : genreMap.keySet()){
            for(String song : genreMap.get(genre)){
                sgMap.put(song,genre);
            }
        }

        //For Each person, go over their song list and put in count map by using sgMap
        for(String user : userMap.keySet()){
            result.put(user,new ArrayList<>());
            countMap = new HashMap<>();
            int max = 0;
            for(String song : userMap.get(user)){
                String genre =  sgMap.get(song);
                countMap.put(genre, countMap.getOrDefault(genre,0)+1);
                max = Math.max(max,countMap.get(genre));
            }
            //Iterate on countmap and get the maxcount genre
            for(String genre : countMap.keySet()){
                if(max == countMap.get(genre)){
                    result.get(user).add(genre);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));

        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        HashMap<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));

        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));

        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));

        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));

        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

        System.out.println(res);
    }
}

