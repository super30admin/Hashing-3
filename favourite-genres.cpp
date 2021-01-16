// Time Complexity: O(kmn)
// Space Complexity: O(mn)
// k = #users
// m = #genres
// n = average #songs in each genre
unordered_map<string, vector<string>> favouriteGenres(unordered_map<string, vector<string>>& userSongs, unordered_map<string, vector<string>>& songGenres) {
    unordered_map<string, vector<string>> result;
    unordered_map<string, string> songToGenre; // space : O(mn)
    for(auto songGenre : songGenres) { // time : O(mn)
        string genre = songGenre.first;
        vector<string> songs = songGenre.second;
        for(auto song : songs) {
            songToGenre[song] = genre;
        }
    }
    // time : O(kmn)
    for(auto userSong : userSongs) { // O(k)
        string user = userSong.first; // name of the user
        // list of particular user's favourite songs
        vector<string> songs = userSong.second;
        // count of songs(fav. songs of user) belonging to each genre
        // key : genre; value : count of songs
        unordered_map<string, int> count; // space : O(m)
        int maxCnt = 0; // maximum count of songs among all the genres
        // In worst case, user can like all mn songs
        for(auto song : songs) { // O(mn)
            count[songToGenre[song]]++;
            maxCnt = max(maxCnt, count[songToGenre[song]]);
        }
        
        for(auto i : count) { // O(m)
            string genre = i.first; // name of the genre
            int nSongs = i.second; // number of songs belonging to a genre
            if(maxCnt == nSongs) {
                result[user].push_back(genre);
            }
        }
    }
    return result;
}

int main() {
    unordered_map<string, vector<string>> userSongs;
    userSongs["David"] = {"song1", "song2", "song3", "song4", "song8"};
    userSongs["Emma"] = {"song5", "song6", "song7"};
    
    unordered_map<string, vector<string>> songGenres;
    songGenres["Rock"] = {"song1", "song3"};
    songGenres["Dubstep"] = {"song7"};
    songGenres["Techno"] = {"song2", "song4"};
    songGenres["Pop"] = {"song5", "song6"};
    songGenres["Jazz"] = {"song8", "song9"};
    
    unordered_map<string, vector<string>> result;
    result = favouriteGenres(userSongs, songGenres);
    for(auto i : result) {
        cout << i.first << " : ";
        for(auto genre : i.second) {
            cout << genre << ", ";
        }
        cout << endl;
    }
}
