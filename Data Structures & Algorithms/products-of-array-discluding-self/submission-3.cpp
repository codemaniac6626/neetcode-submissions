class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int prod = 1;
        vector<int> res;
        int zero = 0;

        for(auto i : nums) if(i != 0) prod *= i; else zero++;

        cout<<zero;

        if(zero == nums.size() || zero > 1) {
            for(auto i : nums) res.push_back(0);
            return res;
        }

        for(int i = 0; i < nums.size(); i++) {
            cout<<nums[i];
            if(nums[i] == 0) {
                res.push_back(prod);
                continue;
            } 
            else if (zero == 1)
                res.push_back(0);
            else {
                cout<<nums[i];
                res.push_back(prod/nums[i]);
            }
        } ;

        return res;
    }
};
