class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> numsUniq = new HashSet<>();
        int longest = 0;

        for(int num : nums)
            numsUniq.add(num);

        for(Integer num : numsUniq) {

            // If its the start of the seq
            if(!numsUniq.contains(num - 1)) {
                int length = 1, curNum = num + 1;
                while(numsUniq.contains(curNum)) {
                    length++;
                    curNum++;
                }
                longest = Math.max(length, longest);
            }

        }
        
        return longest;
            
    }
}
