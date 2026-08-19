class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 0;
        int max=Integer.MIN_VALUE;
        Map<Integer,Integer> l = new HashMap<>();
        for(int ele: nums){
            max=Math.max(max,ele);
            l.put(ele,0);
        }
        int ans =0;
        for(int i=1;i<=max;i++){
            if(!l.containsKey(i)){
                return i;
            }
        }
        if(max<0){
            return 1;
        }
        return max+1;
    }
}