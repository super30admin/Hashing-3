/*
TC : O(N)
SC : O(N)
*/
class Solution
{
public:
    vector<string> findRepeatedDnaSequences(string s)
    {
        if (s.empty() || s.size() < 10)
        {
            return {};
        }

        // to keep track if the substring is repeated DNA
        set<string> checkDup;

        // to store only unique substring
        set<string> resultSet;

        for (int i = 0; i <= s.size() - 10; i++)
        {
            string curr = s.substr(i, 10);
            cout << curr << endl;
            if (checkDup.find(curr) != checkDup.end())
            {
                resultSet.insert(curr);
            }
            checkDup.insert(curr);
        }

        vector<string> result;
        for (auto i : resultSet)
        {
            result.push_back(i);
        }
        return result;
    }
};