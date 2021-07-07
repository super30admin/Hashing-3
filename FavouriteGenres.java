public class Main {
    
    //time - O(number of users * (number of songs + number of genres))
    //space - O(number of songs + number of genres)
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        
        //size of songToGenre map = number of songs
        //time to build songToGenre map = number of songs
        HashMap<String, String> songToGenre = new HashMap<>(); //map of each song to genre
        for(String genre : genreMap.keySet())
        {
            //for each genre - get the list of songs - from genre map
            List<String> songs = genreMap.get(genre);
            for(String song : songs)
            {
                //add this song, genre pair into songToGenre map
                songToGenre.put(song, genre);
            }
        }
        
        HashMap<String, List<String>> result = new HashMap<>(); //return map - map of user to favourite genres
        //time - O(number of users * (number of songs + number of genres))
        //space - O(number of genres)
        for(String user : userMap.keySet())
        {
            //for each user
            List<String> songs = userMap.get(user); //get the corresponding list of songs
            HashMap<String, Integer> genreCount = new HashMap<>(); //map of genre and number of songs in each genre for each user
            int favouriteGenreCount = Integer.MIN_VALUE; 
            List<String> favouriteGenres = new ArrayList<>();
            for(String song : songs)
            {
                //for each song get the genre and update in genreCount map
                //also update the genre that occurs most number of times
                String currentGenre = songToGenre.get(song);
                genreCount.put(currentGenre, genreCount.getOrDefault(currentGenre, 0) + 1);
                if(genreCount.get(currentGenre) > favouriteGenreCount)
                {
                    favouriteGenreCount = genreCount.get(currentGenre);
                    favouriteGenres = new ArrayList<>();
                    favouriteGenres.add(currentGenre);
                }
                else if(genreCount.get(currentGenre) == favouriteGenreCount)
                {
                    favouriteGenres.add(currentGenre);
                }
            }
            
            //alternate way
            // //iterate through the genreCount map and get the genre that occurs favouriteGenreCount times
            // List<String> favouriteGenres = new ArrayList<>();
            // for(String genre : genreCount.keySet()) 
            // {
            //     if(genreCount.get(genre) == favouriteGenreCount)
            //     {
            //         favouriteGenres.add(genre);
            //     }
            // }
            
            result.put(user, favouriteGenres);
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
