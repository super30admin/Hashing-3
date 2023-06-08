// Time Complexity -> O(10*n) ~ O(n)
// Space Complexity -> O(10*n) ~ O(n)

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        int n = s.length();
        set<string> allSubStrings;
        set<string> res;
        
        for(int i = 0; i < n; i++){
            string curr = s.substr(i, 10);
            if(allSubStrings.count(curr))
                res.insert(curr);
            allSubStrings.insert(curr);
        }
        
        vector<string> repeats;
        for(auto itr = res.begin(); itr != res.end(); ++itr)
            repeats.push_back(*itr);
        
        return repeats;
    }
};