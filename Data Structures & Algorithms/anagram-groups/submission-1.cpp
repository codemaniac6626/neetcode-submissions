class Solution {
public:
vector<vector<string>> groupAnagrams(vector<string> &strs)
{
    vector<vector<string>> groups;
    unordered_map<string, vector<string>> m;
    // int group = 1;

    for (int i = 0; i < strs.size(); i++)
    {
        vector<int> freq(26, 0);
        string hash_id = "";

        for (int j = 0; j < strs[i].size(); j++)
        {
            freq[strs[i][j] - 'a']++;

        }

        for (int f : freq)
            hash_id += "#" + to_string(f);

        m[hash_id].push_back(strs[i]);
    }

    for (auto v : m)
    {
        groups.push_back(v.second);
    }

    return groups;
}
};
