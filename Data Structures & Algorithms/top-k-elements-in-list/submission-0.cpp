bool cmp(pair<int, int> a, pair<int, int> b)
{

    return a.second > b.second;
}

class Solution {
public:
vector<int> topKFrequent(vector<int> &nums, int k)
{

    // PUT ALL THE FREQUENCIES IN A MAP
    unordered_map<int, int> m;

    for (auto num : nums)
        m[num]++;

    // FIND THE TOP K FREQUENCIES FROM THE MAP AND STORE THE KEYS IN AN ARRAY.
    vector<pair<int, int>> mVect;

    for (auto i : m)
    {
        mVect.push_back(i);
    }

    // Sort the map by values and take first K entries.
    sort(mVect.begin(), mVect.end(), cmp);

    vector<int> kFrequentNums;

    for (auto i : mVect)
    {
        kFrequentNums.push_back(i.first);
    }

    kFrequentNums.resize(k);

    // RETURN THIS ARRAY
    return kFrequentNums;
}
};
