// songs = n, users = m, genres = k
// Time Complexity : O(n*m) 
// Space Complexity : O(n) for the hashmap song:genre


unordered_map<string, vector<string>> getFavouriteGenre (unordered_map<string, vector<string>> userSongs, unordered_map<string, vector<string>> songGenres) {
    //construct the song: genre hashmap 
    unordered_map<string, string> songsMap;
    for(auto genre: songGenres) {
        for(string song: genre.second)
            songsMap[song] = genre.first;
    }
    
    unordered_map<string, vector<string> > result;
    
    for(auto user:userSongs) {
        unordered_map<string, int> genreCount;
        int maxGenre = -1;
        for(string song: user.second) {
            genreCount[songsMap[song]]++;
            maxGenre = max(maxGenre, genreCount[songsMap[song]]);
        }
        for(auto count: genreCount) {
            if(count.second == maxGenre) {
                result[user.first].push_back(count.first);
            }
        }
    }
    
    return result;
}

int main() {
    unordered_map<string, vector<string>> userSongs; 
        userSongs["David"] =  {"song1", "song2", "song3", "song4", "song8"};
        userSongs["Emma"] = {"song5", "song8", "song7"};

    unordered_map<string, vector<string>> songGenres;
        songGenres["Rock"] = {"song1", "song3"};
        songGenres["Dubstep"] = {"song7"};
        songGenres["Techno"] = {"song2", "song4"};
        songGenres["Pop"] = {"song5", "song6"};
        songGenres["Jazz"] = {"song8", "song9"};
    
    unordered_map<string, vector<string>> result = getFavouriteGenre(userSongs, songGenres);
    for(auto x:result) {
        cout<<x.first<<": ";
        for(string genre: x.second)
            cout<<genre<<" ";
        cout<<endl;
    }
        
    return 0;
}