#include<iostream>
#include<map>
#include<string>
#include<vector>

using namespace std;
map<string,vector<string>> getUserGenres(map<string, vector<string>> userMap, map<string, vector<string>> genreToSong){

    map<string,vector<string>> result;


    //First create a map from song to genre.
    map<string, string> songToGenre;
    for( auto KV: genreToSong ){
        string genre = KV.first;
        for ( auto song: KV.second){
            songToGenre[song] = genre;
        }
    }


    for ( auto KV: userMap){
        string user = KV.first;
        vector<string> partialResult;
        int maxVal = -99999999;
        map<string, int> genreCount;
        for ( auto song: KV.second){
            string genre = songToGenre[song];
            genreCount[genre] += 1;
            maxVal = max( maxVal,  genreCount[genre]);
        }

        for ( auto KV: genreCount){
            if ( maxVal == KV.second){
                partialResult.push_back(KV.first);
            }
        }
        result[user] = partialResult;

    }
    return result;


}


int main(){
    map<string,vector<string>> users;
    users["David"] = {"song1", "song2", "song3", "song4", "song8"};
    users["Emma"] = {"song5", "song6", "song7"};


    map<string,vector<string>> songs;
    songs["Rock"] = {"song1", "song3"};
    songs["Dubstep"] = {"song7"};
    songs["Techno"] = {"song2", "song4"};
    songs["Pop"] = {"song5", "song6"};
    songs["Jazz"] = {"song8", "song9"};

    auto result = getUserGenres(users, songs);

    for(auto x: result)
    {
        cout<<x.first<<" : ";
        for(auto song:x.second)
        {
            cout<<song<<" ";
        }
        cout<<endl;
    }
}

