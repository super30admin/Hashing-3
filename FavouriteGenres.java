import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// "static void main" must be defined in a public class.
public class Main {

    //Time Complexity: 0(mk) + 0(nz) where m is the no. of genres, k is the average length of songs in each genre. n is the no of users and z is the average lenght of longs listened by each user
    //Space Complexity: 0(mk)

    public static HashMap<String, List<String>> FindTopGenre(HashMap<String, List<String>> userToSong, HashMap<String, List<String>> genreToSong){

        HashMap<String, String> songToGenre = new HashMap<>();  //I am creating a hashmap to map each song that belongs to a particular genre
        HashMap <String, List<String>> result = new HashMap<>();    //to return result

        for(String genre : genreToSong.keySet()){   //I go over my genre to song and map each song to its genre
            List<String> songs = genreToSong.get(genre);
            for(String song : songs){
                songToGenre.put(song,genre);
            }
        }

        for(String user : userToSong.keySet()){ //Now i go over my user to song map to check the most listened genre by user
            HashMap <String, Integer> genreToFrequency = new HashMap<>();   //I create a hashmap to map genre to frequency for each user
            int max = 0;    //the max keeps a track of the most frequency of genre listened by a user
            List <String> userSongs = userToSong.get(user); //to go over the songs by each user
            for(String userSong : userSongs){
                String genre = songToGenre.get(userSong);   //getting the genre of each song from the map that I created
                genreToFrequency.put(genre, genreToFrequency.getOrDefault(genre, 0) + 1);   //adding it to hashmap, if already exists, increasing its count
                max = Math.max(max, genreToFrequency.get(genre));   //updating max with the max or the current frequency
            }
            List <String> allGenre = new ArrayList<>(); //array list to store multiple favourite genres of each user
            for(String favgenre: genreToFrequency.keySet()){    //going over my genre to frequency map to figure out the most listened genre
                if(max == genreToFrequency.get(favgenre)){  //if max is equal to the frequency, means it is the most listened genre
                    allGenre.add(favgenre); //adding it to my list
                }
            }
            result.put(user, allGenre); //adding the user's name and list to my final result
        }

        return result;
    }

    public static void main(String[] args) {

        HashMap<String, List<String>> userToSong = new HashMap<>();
        HashMap<String, List<String>> genreToSong = new HashMap<>();

        userToSong.put("Ann", Arrays.asList("Song1", "Song2", "Song5", "Song7"));
        userToSong.put("David", Arrays.asList("Song5", "Song3", "Song4", "Song8"));
        userToSong.put("Mel", Arrays.asList("Song2", "Song9", "Song10"));

        genreToSong.put("Rock", Arrays.asList("Song1", "Song4", "Song8"));
        genreToSong.put("Jazz", Arrays.asList("Song2", "Song5", "Song7"));
        genreToSong.put("Pop", Arrays.asList("Song3", "Song6", "Song9"));
        genreToSong.put("Country", Arrays.asList("Song10"));

        HashMap<String, List<String>> result = FindTopGenre(userToSong, genreToSong);
        System.out.println(result);
    }
}