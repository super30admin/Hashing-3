//Problem 1: DNA Sequenceing
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10) return new ArrayList<>();
        // HashSet<String> allSubs= new HashSet<>();
        // HashSet<String> result= new HashSet<>();
        // for(int i=0;i<s.length()-9;i++){
        //     String sub=s.substring(i,i+10); //10
        //     if(allSubs.contains(sub)){
        //         result.add(sub);
        //     }else{
        //         allSubs.add(sub);
        //     }
        // }
        // return new ArrayList<>(result);
        Map<Character, Integer> map=new HashMap<>();
        map.put('A',1);
        map.put('C',2);
        map.put('G',3);
        map.put('T',4);
        HashSet<Long> allSubs= new HashSet<>();
        HashSet<String> result= new HashSet<>();
        long hash=0l;

        for(int i=0;i<s.length();i++){
            if(i>=10){
                char out=s.charAt(i-10);
                long kl=(long)Math.pow(4, 9);
                hash= hash - kl*map.get(out); //process outgoing Character
            }
                //process incoming
                char incoming=s.charAt(i);
                hash=hash*4+map.get(incoming);
                if(allSubs.contains(hash)){
                    result.add(s.substring(i-9, i+1));
                }else
                    allSubs.add(hash);
        }
        return new ArrayList<>(result);
    }
}


//Problem 2: Fav Genre
// Time Complexity : O(nm) n=number of songs, m=participants
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//O(nm) n=number of songs, m=participants
//O(n)
public class main{
public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
    HashMap<String, List<String>> res = new HashMap<>();
    HashMap<String, String> songToGenre = new HashMap<>();
    
    for(String gen: genreMap.keySet()){
        for(String song: genreMap.get(gen)){
            songToGenre.put(song, gen);
        }
    }
    
    HashMap<String, Integer> countMap;
    for(String user: userMap.keySet()){
        countMap= new HashMap<>();
        res.put(user, new ArrayList<>());
        int max=0;
        List<String> songs=userMap.get(user);
        for(String sng: songs){
            String genre= songToGenre.get(sng);
            countMap.put(genre, countMap.getOrDefault(genre,0)+1);
            max=Math.max(max,countMap.get(genre));
        }
        for(String genre: countMap.keySet()){
            if(countMap.get(genre)==max){
                res.get(user).add(genre);
            }
        }
    }
    
    return res;
    
    
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