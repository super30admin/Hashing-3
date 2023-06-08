// Time Complexity -> O(m*n), where 'm' is the number of users and 'n' is the number of songs.
#include <iostream>
#include <bits/stdc++.h>

using namespace std;

unordered_map<string, vector<string>> favoriteGenre(unordered_map<string, vector<string>>& userMap, unordered_map<string, vector<string>>& genreMap) {
    unordered_map<string, string> songToGenre;
    for (auto& genrePair : genreMap) {
        string genre = genrePair.first;
        vector<string> songs = genrePair.second;
        for (string song : songs) {
            songToGenre[song] = genre;
        }
    }
    
    unordered_map<string, vector<string>> result;
    unordered_map<string, unordered_map<string, int>> countMap;
    for (auto& userPair : userMap) {
        string user = userPair.first;
        result[user] = vector<string>();
        countMap[user] = unordered_map<string, int>();
        int maxCount = 0;
        vector<string> songs = userPair.second;
        for (string song : songs) {
            string genre = songToGenre[song];
            int count = countMap[user][genre] + 1;
            maxCount = max(maxCount, count);
            countMap[user][genre] = count;
        }
        for (auto& countPair : countMap[user]) {
            string genre = countPair.first;
            int count = countPair.second;
            if (count == maxCount) {
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
    
    unordered_map<string, vector<string>> res = favoriteGenre(userSongs, songGenres);
    
    for (auto& userPair : res) {
        string user = userPair.first;
        vector<string> favoriteGenres = userPair.second;
        cout << user << ": ";
        for (string genre : favoriteGenres) {
            cout << genre << " ";
        }
        cout << endl;
    }
    
    return 0;
}
