// Time Complexity : O(n)
// Space Complexity : O(n)

/*
Maintain 2 hashsets - 1 to find repeated sub-sequence and 1 to uniquely store the result
*/

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        if(s.length() <= 10)
            return vector<string>();
        unordered_set<string> allSequences;
        unordered_set<string> resultSet; 
        vector<string> result;

        for(int i = 0; i <= s.length()-10; i++) {
            string sequence = s.substr(i, 10);
            if(allSequences.find(sequence) == allSequences.end())
                allSequences.insert(sequence);
            else 
                resultSet.insert(sequence);
        }

        result.insert(result.end(), resultSet.begin(), resultSet.end());
        return result;
    }
};