package problems.hashing;

import java.util.*;

public class Problem169 {
    public Map<String, List<String>> favouriteGenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> result=new HashMap<>();
        HashMap<String,String> songToGenre=new HashMap<>();
        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for (String song: songs) {
                songToGenre.put(song,genre);
            }
        }
        int max=0;
        for (String user : userMap.keySet()) {
            result.put(user,new ArrayList<>());
            List<String> songs = userMap.get(user);
            HashMap<String,Integer> genereCount=new HashMap<>();
            for (String song: songs) {
                String genre=songToGenre.get(song);
                genereCount.put(genre,genereCount.getOrDefault(genre,0)+1);
                max=Integer.max(max,genereCount.get(genre));
            }
            for (String genere : genereCount.keySet()){
                if(genereCount.get(genere)==max){
                    result.get(user).add(genere);
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
        Problem169 problem=new Problem169();
        System.out.println(problem.favouriteGenre(userSongs, songGenres));
    }
}

