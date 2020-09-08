// "static void main" must be defined in a public class.
/*
Approach:
To find favorit of each user make a genre to count mapping for each user.
Whichever has max count that is the favorite for that user
Also make the haashmap for song to genre .

*/
public class FavoriteGenre {
    public static void main(String[] args) {
       HashMap<String,List<String>> userMap= new HashMap();
        userMap.put("David",Arrays.asList(new String[]{"Song1","Song2","Song3","Song4","Song8",}));
          userMap.put("Emma",Arrays.asList(new String[]{"Song5","Song6","Song7"}));
       HashMap<String,List<String>> genreMap = new HashMap();
        genreMap.put("Rock",Arrays.asList(new String[]{"Song1","Song3"}));
       genreMap.put("Dubstep",Arrays.asList(new String[]{"Song7"}));              
        genreMap.put("Techno",Arrays.asList(new String[]{"Song2","Song4"}));
      genreMap.put("Pop",Arrays.asList(new String[]{"Song5","Song6"}));
      genreMap.put("Jazz",Arrays.asList(new String[]{"Song8","Song9"}));            
        Map<String,List<String>>  res = FavoriteGenre.favoritGenre(userMap,genreMap);
        System.out.println("Favorite songs World! "+res);
       
    }
    //userMap is user to song
    //genreMap is genre to song
    public static Map<String,List<String>> favoritGenre( Map<String,List<String>> userMap, Map<String,List<String>> genreMap)      {
          Map<String,List<String>> result = new HashMap();
          Map<String,String> songsToGenre = new HashMap();
          for(String genre : genreMap.keySet()){
              List<String> allSongs = genreMap.get(genre);
              for(String song : allSongs){
                  songsToGenre.put(song,genre);
              }
          }
       
        HashMap<String,Integer> count;
        for(String user: userMap.keySet()){
            int max = 0;
            count = new HashMap();
            result.put(user,new ArrayList());
            List<String> likedSongs = userMap.get(user);
            for(String song : likedSongs){
                String genre  = songsToGenre.get(song);
                int cnt = count.getOrDefault(genre,0)+1;
                max = Math.max(max,cnt);
                count.put(genre,cnt);
            }
           
            for(String genre : count.keySet()){
                if(count.get(genre) == max){
                    result.get(user).add(genre);
                }
            }
            }
        return result;
        }
     
}

/*
Timecomplexity: O(n) where n is no of songs .
Space complexity = O(1)
*/
