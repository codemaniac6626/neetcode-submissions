class Solution {
public:
string encode(vector<string> &strs)
{
    // COMMA SEP. THE ASCII VALUES

    string encoded = "";

    for (int i = 0; i < strs.size(); i++)
    {
        string str = strs[i];
        string strHash = "";
        for (int j = 0; j < str.size(); j++)
        {
            strHash += to_string(str[j] - 'a');
            strHash += "|";
        }

        encoded += strHash;
        encoded += ",";
    }

    return encoded;
}

vector<string> decode(string s)
{
    vector<string> inter1;
    vector<vector<int>> inter2;
    vector<string> res;

    string temp = "";

    for (auto c : s)
    {
        if (c == ',')
        {
            inter1.push_back(temp);
            temp = "";
        }
        else
            temp += c;
    }

    for (auto s : inter1)
    {
        vector<int> ascii;
        temp = "";

        for (int i = 0; i < s.size(); i++)
        {
            /* code */
            if (s[i] == '|')
            {
                ascii.push_back(stoi(temp));
                // cout<<temp<<",";
                temp = "";
                continue;
            }

            temp += s[i];
        }

        inter2.push_back(ascii);
    }

    // cout<<inter2[0].size()<<endl;

    for (auto v : inter2)
    {

        string value = "";

        for (auto i : v)
        {
            value += char(int('a') + i);
        }

        res.push_back(value);
    }

    return res;
}
};
