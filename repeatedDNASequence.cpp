//Time:O(n) where n is the size
//Space:O(n)
class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        set<string> hSet,hSetRes;
        int n  = s.length();
        int j =0;
        string newStr;
        for(int i = 0; i < n-9;i++){
            newStr = s.substr(i,10);
            if(hSet.count(newStr)) hSetRes.insert(newStr);
            else hSet.insert(newStr);
        }
        vector<string> ans(hSetRes.begin(),hSetRes.end());
        return ans;
    }
};