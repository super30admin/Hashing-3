/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

#include<iostream>
#include<vector>
#include<string>
#include<unordered_map>

using namespace std;

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        const int window_len{10};
        unordered_map<string,int> umap{};
        vector<string> res{};
        int s_len = s.size();
        //cout<<s_len<<endl;
        if(s_len<=window_len) return res;
        for(int i{};i<s_len-window_len+1;++i){
            string temp = s.substr(i,window_len);
            if(umap.find(temp)==umap.end()){
                umap[temp]=0;
            }
            else{
                umap[temp]++;
            }
        }
        for(const auto& pair:umap){
            if(pair.second>0){
                res.push_back(pair.first);
            }
        }
        return res;
    }
};