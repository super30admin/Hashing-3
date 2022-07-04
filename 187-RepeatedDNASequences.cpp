/* 
    Time Complexity                              :  ~=O(N)
    Space Complexity                             :  O(N) when all the sequences are different except one
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        int i=0,sz = s.size();
        unordered_map<string,int> mp;
        string temp = "";
        vector<string> ans;
            
        while(i < sz) {
            if(i < 10) {
                temp += s[i];
            } else {
                temp = temp.substr(1) + s[i];
            }
            mp[temp]++;
            i++;
        }
        
        
        for(auto m : mp) {
            if(m.second > 1) {
                ans.push_back(m.first);
            }
        }
        
        
        return ans;
    }
};