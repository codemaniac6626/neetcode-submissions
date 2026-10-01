class Solution {
public:

    string encode(vector<string>& strs) {
        string enc = "";
        vector<int> lengths;

        lengths.push_back(strs.size());

        for(auto s = strs.begin() ; s != strs.end() ; s++) {
            lengths.push_back(s->size());
            enc += *s;
        }

        for(int i = lengths.size() -1 ; i >= 0 ; i--) {
            enc = to_string(lengths[i]) + "|" + enc;
        }

        return enc;
    }

    vector<string> decode(string s) {
        cout<<s;
        vector<string> dec;

        vector<int> lengths;

        int size = 0;

        string temp = "";

        int i,p;

        for(i = 0, p = 0; p == 0 ; i++) {

            if(int(s[i]) == int('|')) {
                size = stoi(temp);
                temp = "";
                p++;
                continue;
            }

            temp += s[i];
        }

        for( ; p < size + 1 ; i++) {

            if(int(s[i]) == int('|')) {
                lengths.push_back(stoi(temp));
                temp = "";
                p++;
                continue;
            }

            temp += s[i];
        }

        temp = "";

        int wc = 0;

        cout<<endl;

        for(int j = 1; wc < lengths.size(); ) {

            if(lengths[wc] == 0) {
                dec.push_back("");
                wc++;
                j=1;
                continue;
            }

            temp += s[i];

            if(j == lengths[wc]) {
                dec.push_back(temp);
                j=0;
                temp = "";
                wc++;
            }

            if(i < s.size()) {
                i++;
                j++;
            }
        }

        return dec;
    }
};
