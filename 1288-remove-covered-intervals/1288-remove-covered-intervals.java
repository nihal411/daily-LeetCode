class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int c=0;
        int ans =0;
        for(int[] a: intervals){
            if(a[1]>ans){
                ans=a[1];
                c++;
            }
        }
        return c;
    }
}