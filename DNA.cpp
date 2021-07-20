/*
We use a sliding window (2 pointer technique) to get all possible substrings.
We store it in a set. If they repeat again we put it in a result.
Time Complexity: O(N*L), Here L = 10.
Space Compleixty: O(N*L), All strings are unique.
*/

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        set<string>resultSet;
        set<string>potentialString;
        string newString = "";
        for ( int i = 0; i+10 <= s.size(); i++){
            newString = s.substr(i,10);
            cout<<newString<<endl;
            if ( potentialString.find(newString) != potentialString.end()){
                resultSet.insert(newString);
            }
            potentialString.insert(newString);
            
        }
        vector<string>result;
        for ( auto val: resultSet){
            result.push_back(val);
            
        }
        return result;
    }
};