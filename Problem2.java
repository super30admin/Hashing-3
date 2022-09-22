//Time Complexity: O(m) + O(n*k); where m is the total songs, n is the users & k is the avg. songs per user.
//Space Complexity: O(m) + O(n*k)
//Code run successfully on LeetCode.

public class Problem2 {

	public class Main
	{

	public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {

	    HashMap<String,String> songs = new HashMap<>();
	    for(String g : songGenres.keySet())
	    {
	        List<String> song = songGenres.get(g);
	        
	        for(String s : song)
	        {
	            songs.put(s,g);
	        }
	    }
	    
	    Map<String, List<String>> result = new HashMap<>();
	    
	    for(String u : userSongs.keySet())
	    {
	        List<String> song = userSongs.get(u);
	        HashMap<String,Integer> map = new HashMap<>();
	        int max = Integer.MIN_VALUE;
	        
	        for(String s : song)
	        {
	            String g = songs.get(s);
	            
	            map.put(g, map.getOrDefault(g,0) + 1);
	            max = Math.max(max, map.get(g));
	        }
	        
	        List<String> ans = new ArrayList<>();
	        
	         for(String g : map.keySet())
	         {
	             if(map.get(g) == max)
	                 ans.add(g);
	         }
	        
	        result.put(u,ans);
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
}
