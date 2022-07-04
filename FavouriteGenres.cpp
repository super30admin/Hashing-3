/* 
    Time Complexity                              :  O(max(m*n, x*n)) where m is the number of user and n is the number of songs. 
                                                    x is the number of genres and n is the number of songs
    Space Complexity                             :  O(x*n) to store all the song to genre mapping
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include<bits/stdc++.h>
using namespace std;


unordered_map<string,vector<string>> favoriteGenres(unordered_map<string,vector<string>>& userSongs, unordered_map<string, vector<string>>& genreSongs) {
    unordered_map<string,vector<string>> ans;
    int genres = genreSongs.size();
    unordered_map<string,string> songGenre;



    for(auto genreSong : genreSongs) {
        string genre = genreSong.first;
        vector<string> songs = genreSong.second;
        for(string song : songs) {
            songGenre[song] = genre;
        }
    }
    
    for(auto userSong : userSongs) {
        unordered_map<string,int> userSongGenreCount;
        int mx = INT_MIN;
        string user = userSong.first;
        vector<string> songs = userSong.second;
        
        for(auto song : songs) {
            string genre = songGenre[song];
            userSongGenreCount[genre]++;
            if(mx < userSongGenreCount[genre])
                mx = userSongGenreCount[genre];
        }
        
        for(auto m : userSongGenreCount) {
            int count = m.second;
            if(count == mx) {
                string genre = m.first;
                if(ans.find(user) == ans.end()) {
                    ans[user] = vector<string>();
                }
                ans[user].push_back(genre);
            }
        }
    }
    
    return ans;
    
    
}

int main() {
    unordered_map<string,vector<string>> userSongs, genreSongs;
    
    userSongs["David"] = {"song1", "song2", "song3", "song4", "song8"};
    userSongs["Emma"] = {"song5", "song6", "song7"};
    
    genreSongs["Rock"] = {"song1", "song3"};
    genreSongs["Dubstep"] = {"song7"};
    genreSongs["Techno"] = {"song2", "song4"};
    genreSongs["Pop"] = {"song5", "song6"};
    genreSongs["Jazz"] = {"song8", "song9"};
    
    
    unordered_map<string,vector<string>> mp = favoriteGenres(userSongs, genreSongs);
    
    for(auto m : mp) {
        string user = m.first;
        cout << "user = " << user << "\n";
        vector<string> genres = m.second;
        for(string genre : genres) {
            cout << "    " << genre << "\n";
        }
    }
}