class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max[]= new int[nums.length];
        int min[]= new int[nums.length];
        int n = nums.length;
        int a=-1;
        for(int i=0;i<n;i++){
             a= Math.max(a,nums[i]);
            max[i]=a;
        }
        a=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            a= Math.min(a,nums[i]);
            min[i]=a;
        }
        for(int i=0;i<n;i++){
            if((max[i]-min[i])<=k){
                return i;
            }
        }
        return -1;
    }
}