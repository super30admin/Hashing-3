/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

#include<iostream>
#include<vector>
#include<unordered_map>
#include<string>

using namespace std;

void display(unordered_map<string,string>& gg){
    for(const auto& song:gg){
        cout<<song.first<<" "<<song.second<<endl;
    }
}

void display(unordered_map<string,vector<string>>& gg){
    for(const auto& name:gg){
        cout<<name.first<<" : ";
        for(const auto& genre:name.second){
            cout<<genre<<" , ";
        }
        cout<<endl;
    }
}

int main(){
    unordered_map<string, vector<string>> userSongs = {
        {"David", {"song1", "song2", "song3", "song4", "song8"}},
        {"Emma", {"song5", "song6", "song7"}}
    };

    unordered_map<string, vector<string>> songGenres = {
        {"Rock", {"song1", "song3"}},
        {"Dubstep", {"song7"}},
        {"Techno", {"song2", "song4"}},
        {"Pop", {"song5", "song6"}},
        {"Jazz", {"song8", "song9"}}
    };
    unordered_map<string,vector<string>> res{};
    unordered_map<string,string> rev_song{};
    for(const auto& genre:songGenres){
        for(const auto& str:genre.second){
            rev_song[str] = genre.first;
        }
    }
    //now get the top genres for each user
    for(const auto& user:userSongs){
        res[user.first] = vector<string>{};
        unordered_map<string,int> count{};
        int max_count{};
        for(const auto& song:user.second){
            string genre = rev_song[song];
            if(count.find(genre)==count.end()){
                count[genre] = 0;
            }
            count[genre]++;
            max_count = max(max_count,count[genre]);
        }
        for(const auto& cc:count){
            if(cc.second == max_count){
                res[user.first].push_back(cc.first);
            }
        }
    }
    display(rev_song);
    display(res);
    return 0;
}