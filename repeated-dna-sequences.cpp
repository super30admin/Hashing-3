//Time - O(n)
//Space - O(n)
class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> ans;
        if(s.size()<10) return ans;
        unordered_map<string,int> mp;
        for(int i=0;i<=s.size()-10;i++){
            string str = s.substr(i,10);
            if(mp.find(str)==mp.end()){
                mp[str] = 1;
            }else if(mp[str] == 1){
                mp[str] = 2;
                ans.push_back(str);
            }
        }
        return ans;
    }
};