# Hashing-3

## Problem1 Repeated DNA Sequences (https://leetcode.com/problems/repeated-dna-sequences/)

//TimeComplexity = O(N)
//Space Complexity = O(N)

class Solution {
public List<String> findRepeatedDnaSequences(String s) {
if(s == null || s.length() == 0) {
return new ArrayList<>();
}

        HashSet<String> dnas = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        for(int i = 0 ; i < s.length() - 9; i++) {
            String current = s.substring(i,i+10);
            if(dnas.contains(current)) {
                result.add(current);
            }
            dnas.add(current);
        }

        return new ArrayList<>(result);
    }

}

## Problem2 Favourite Genres

Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.

Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.

The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.

Example 1:

Input:

userSongs = {

"David": ["song1", "song2", "song3", "song4", "song8"],

"Emma": ["song5", "song6", "song7"]

},

songGenres = {

"Rock": ["song1", "song3"],

"Dubstep": ["song7"],

"Techno": ["song2", "song4"],

"Pop": ["song5", "song6"],

"Jazz": ["song8", "song9"]

}

Output: {

"David": ["Rock", "Techno"],

"Emma": ["Pop"]

}

Explanation:

David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.

Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.

public class Main {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

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

//TimeComplexity = O(M*N)
//Space Complexity = O(M*N)

public class Main {
public static Map<String, List<String>> favGenre(Map<String, List<String>> userMap,
Map<String, List<String>> genreMap) {

        if(userMap == null || genreMap == null) {
            return new HashMap<>();
        }

        HashMap<String, String> songToGenre = new HashMap<>();

        for(String g : genreMap.keySet()) {
            String genre = g;
            List<String> songs = genreMap.get(g);

            for(String song : songs) {
                songToGenre.put(song,genre);
            }
        }

        HashMap<String, Integer> countMap;
        HashMap<String, List<String>> result = new HashMap<>();
        for(String user : userMap.keySet()) {
            countMap = new HashMap<>();
            result.put(user, new ArrayList<>());
            List<String> songs = userMap.get(user);
            int max = 0;

            for(String song : songs) {
                String genre = songToGenre.get(song);
                countMap.put(genre, countMap.getOrDefault(genre,0) + 1);
                max = Math.max(max, countMap.get(genre));
            }

            for(String genre : countMap.keySet()) {
                if(countMap.get(genre) == max) {
                    result.get(user).add(genre);
                }
            }
        }
         return result;


    }

    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));

        Map<String, List<String>> res = favGenre(userSongs,songGenres);
        System.out.println(res);


    }

}

// Campus Bikes

//TimeComplexity = O(M*N)
//Space Complexity = O(M*N)

class Solution {
public int[] assignBikes(int[][] workers, int[][] bikes) {
if(workers == null || workers.length == 0 || bikes == null || bikes.length == 0) {
return new int[0];
}

        Map<Integer, List<int[]>> map = new HashMap<>();
        int wlen = workers.length;
        int blen = bikes.length;
        int[] result = new int[wlen];
        int max = 2001;
        int min = 0;

        for(int i = 0 ; i < wlen; i++) {
            for(int j = 0 ; j < blen; j++) {
                int dist = manhattanDistance(workers[i],bikes[j]);

                max = Math.max(dist,max);
                min = Math.min(dist,min);

                if(!map.containsKey(dist)) {
                    map.put(dist, new ArrayList<>());
                }
                map.get(dist).add(new int[]{i,j});
            }
        }
        int count = 0;
        boolean[] assignedWorkers = new boolean[workers.length];
        boolean[] assignedBikes = new boolean[bikes.length];

        for(int dist = min; dist <= max; dist++) {

            if(map.containsKey(dist)) {
                List<int[]> distList = map.get(dist);
                for(int[] pair : distList) {
                    int worker = pair[0];
                    int bike = pair[1];

                    if(!assignedBikes[bike] && !assignedWorkers[worker]) {
                        count++;
                        result[worker] = bike;
                        assignedBikes[bike] = true;
                        assignedWorkers[worker] = true;
                    }
                    if(count == wlen) {
                        return result;
                    }
                }
            }
        }
        return result;





    }

    private int manhattanDistance(int[] worker,int[] bikes) {
        return Math.abs(worker[0] - bikes[0]) + Math.abs(worker[1] - bikes[1]);
    }

}
