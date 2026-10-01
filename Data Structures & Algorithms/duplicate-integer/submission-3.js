class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    hasDuplicate(nums) {
        let seen = []
        for (const num of nums) {
            if (seen.findIndex((v) => v === num) !== -1) return true;
            seen.push(num)
        }

        return false;
    }


  
$0}
