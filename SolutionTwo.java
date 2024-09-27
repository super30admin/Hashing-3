// Time Complexity :O(kmn)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : yes

class SolutionTwo {
    public Map<String,List<String>> findRepeatedDnaSequences(Map<String,List<String>> userMap, Map<String,List<String>> genreMap) {

        HashMap<String,List<String>> result = new HashMap<>();

        HashMap<String,List<String>> songToGenre = new HashMap<>();//sc mn

        //m genre
        ///n songs

        //tc mn
        for(String genre:genreMap.get())
        {
          List<String> songs = genreMap.get(genre);

          for(String song:songs)
          {
              songToGenre.put(song,genre);
          }

        }

        String <String,Integer> count;

        //k users
        for(String user:userMap.keySet())
        {
            count = new HashMap<>();
            int max =0;
            result.put(user,new ArrayList<>());

            List<String> songs = userMap.get(user);

            for(String song: songs)
            {
                String genre = songToGenre.get(song);
                count.put(genre,count.getOrDefault(genre,0)+1);
                max = Math.max(max,count.get(genre));

            }
            for(String genre: count.keySet())
            {
                result.get(user).add(genre);
            }
        }

        result;
    }
}