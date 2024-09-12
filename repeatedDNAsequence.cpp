class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_map<string,int> um;
        unordered_set<string> us;
        vector<string> answer;
       
        if (s.length()<10) { 
            return answer;
        }
        for (int i=0;i<=s.length()-10;i++) {
            string a=s.substr(i,10);
            if (um[a]>=1) {
                us.insert(a);
                //answer.push_back(a);
            } else {
                um[a]++;
            }
        }
        for(auto x:us) {
            answer.push_back(x);
        }
        return answer;
    }
};