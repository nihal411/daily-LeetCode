class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        int c=0;
        int i=0;
        int j=0;
        while(j<nums.length){
            m.put(nums[j],m.getOrDefault(nums[j],0)+1);
            while(m.get(nums[j])>k){
                m.put(nums[i],m.get(nums[i])-1);
                i++;
            }
            c=Math.max(c,j-i+1);
            j++;
        }
        return c;
    }
}