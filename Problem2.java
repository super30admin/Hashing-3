public class Problem2 {
    private Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songToGenre = new HashMap<>();

        for (String key:songGenres.keySet()) {
            List<String> songs = songGenres.get(key);

            for (String song: songs) {
                songToGenre.put(song, key);
            }
        }
        Map<String, Integer> songFreqMap = new HashMap<>();

        for (String user:userSongs.keySet()) {
            int max = 0;

            List<String> songs = userSongs.get(user);
            List<String> result = new ArrayList<>();
            for (String song:songs) {
                songFreqMap.put(songToGenre.get(song), songFreqMap.getOrDefault(songToGenre.get(song), 0)+1);

                if (max<songFreqMap.get(songToGenre.get(song))) {
                    result.clear();
                    result.add(songToGenre.get(song));
                    max = songFreqMap.get(songToGenre.get(song));
                }
                else if (max==songFreqMap.get(songToGenre.get(song))) {
                    result.add(songToGenre.get(song));
                }
            }
            res.put(user, result);
        }
        return res;
    }