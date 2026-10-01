class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> res;

        int pref=1;
        
        for(int i = 0; i < nums.size(); i++) {
            res.push_back(pref);
            pref = pref*nums[i];
        }

        int post=1;

        for(int i = nums.size() - 1; i >= 0; i--) {
            res[i] = res[i]*post;
            post=post*nums[i];
        }

        return res;
    }
};
