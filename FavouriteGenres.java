/*
The time complexity is O((U + S1) + (G + S2)) where U stands for total number of users and S1 stands for total number of songs in userSongs
hashmap. G stands for total number of genres and S2 stands for total number of songs in songGenres hashmap.
The space complexity is O(S2) where we are storing song and genres in Genres hashmap.

Here we will be preprosessing the songGenres hashmap to get create another hashmamp which contains song as key and its genre as value.
After which we iterate through each user song list and get the genreCount hashmap which consists of genre as key and value of number of
songs the particulcar user likes in that particular genre. Get the highest count and its corresponding genre. Dump it into an arraylist.
So at the end of the program we have one output hasmap containing user as key and his favourite genres in a list as value.

The problem is not present in leetcode.
 */
public class Main {
    public static void main(String[] args) {

        Map<String, List<String>> userSongs = new HashMap<>();
        Map<String, List<String>> songGenres = new HashMap<>();

        List<String> david = new LinkedList<>();
        david.add("song1"); david.add("song2"); david.add("song3"); david.add("song4");
        david.add("song8");

        List<String> emma = new LinkedList<>();
        emma.add("song5"); emma.add("song6"); emma.add("song7");

        userSongs.put("David",david); userSongs.put("Emma",emma);

        List<String> rock = new LinkedList<>(); rock.add("song1"); rock.add("song3");

        List<String> dubstep = new LinkedList<>(); dubstep.add("song7");

        List<String> techno = new LinkedList<>(); techno.add("song2"); techno.add("song4");

        List<String> pop = new LinkedList<>(); pop.add("song5"); pop.add("song6");

        List<String> jazz = new LinkedList<>(); pop.add("song8"); pop.add("song9");

        songGenres.put("Rock",rock); songGenres.put("Dubstep",dubstep);
        songGenres.put("Techno",techno); songGenres.put("Pop",pop);
        songGenres.put("Jazz",jazz);

        Map<String,List<String>> retMap = topGenres(userSongs,songGenres);
        for(String eachUser:retMap.keySet()){
            System.out.println(eachUser);
            for(String eachGenre:retMap.get(eachUser)){
                System.out.print(eachGenre+" ");
            }
            System.out.println();
        }

    }

    public static Map<String,List<String>> topGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres){

        //Get song,genre hashmap.
        HashMap<String,String> Genres = new HashMap<>();
        for(String each:songGenres.keySet()){
            List<String> songlist = songGenres.get(each);
            for(String eachSong:songlist){
                Genres.put(eachSong,each);
            }
        }

        HashMap<String,List<String>> outputMap = new HashMap<>();

        //Iterate through each user
        for(String eachUser:userSongs.keySet()){
            Map<String,Integer> genreCount = new HashMap<>();

            //Iterate through each song and create a hashmap containing genre as key and count as value.
            for(String eachSong:userSongs.get(eachUser)){
                String genre = Genres.get(eachSong);
                if(genreCount.containsKey(genre)){
                    int count = genreCount.get(genre);
                    genreCount.put(genre,count+1);
                }
                else{
                    genreCount.put(genre,1);
                }
            }

            //Get the top count and add its genre to an array list.
            List<String> topGenres = new ArrayList<>(); int max = Collections.max(genreCount.values());
            for(String eachGenre:genreCount.keySet()){
                if(genreCount.get(eachGenre)==max){
                    topGenres.add(eachGenre);
                }
            }

            //Add user and his array list to output map.
            outputMap.put(eachUser,new ArrayList<>(topGenres));
        }

        return outputMap;
    }
}