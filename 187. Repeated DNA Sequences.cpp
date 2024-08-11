/*
Time: O(n) * 10
Space: O(n)

Encode dna sequence of 10 to its long representation and use unordered map to count occurences
*/

class Solution {
public:
    int value(char g){
        if(g == 'A')  return 1;
        if(g == 'T')  return 2;
        if(g == 'G')  return 3;
        if(g == 'C')  return 4;

        return 1213214;
    }

    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> ret;
        unordered_map<long long, int> m;

        //edge case
        if(s.length() < 10)  return {};

        long long hash = 0;
        long long mod = 1e9; //for 10 digits, the MSD is at 9th position (modding by 1e9 will remove it)

        for(int i=0;i<10;i++){
            hash = hash * 10 + value(s[i]);
        }
        m[hash] = 1;

        for(int i=10;i<s.length();i++){
            hash %= mod;
            hash = hash * 10 + value(s[i]);

            m[hash]++;
            if(m[hash] == 2){ //to avoid duplicates, insert just when the occurance count reach 2 and never insert again for further occurence
                ret.push_back(s.substr(i-10+1,10));
            }
        }

        return ret;
    }
};
