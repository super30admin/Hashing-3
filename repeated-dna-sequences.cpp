// Time Complexity: O(N) N = size of s
// Space Complexity: O(N)
class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        if(s.size() <= 9) return {};
        vector<string> res;
        set<string> set1;
        set<string> set2;
        
        for(int i = 0; i < s.size()-9; i++) {
            string temp = s.substr(i, 10);
            if(set1.find(temp) == set1.end()) {
                set1.insert(temp);
            }
            else if(set2.find(temp) == set2.end()) {
                set2.insert(temp);
                res.push_back(temp);
            }
        }
        return res;
    }
};
