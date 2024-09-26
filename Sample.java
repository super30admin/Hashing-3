class Solution{
	
	public static Map<String, List<String>> findGenre(Map<String, List<String>> userList, Map<String, List<String>> genreList{
		HashMap<String, List<String>> result = new HashMap<>(); 
		for(Map.Entry<String, List<String>> entry: userList.entrySet()){
			String user = entry.getKey();
			List<String> userSongs = entry.getValue();
			HashMap<String, Integer> map = new HashMap<>();

			for(String userSong: userSongs){

				for(Map.Entry<String, List<String>> entry: genreList.entrySet()){
					String genre = entry.getKey();
					List<String> genreSongs = entry.getValue();

					if(genreSongs.contains(userSong)){
						map.put(genre, map.getOrDefault(genre,0)+1);
					}
				}
			}
			int max_val = 0;
			List<String> user_genres = new ArrayList<>();
			for(Map.Entry<String, Integer> entry: map.entrySet()){
				if(entry.getValue >= max_val){
					max_val = entry.getValue();
					user_genres.add(entry.getKey());
				}
			}
			result.put(user, user_genres);
		}
		return result;
	}
}
