class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> s = new HashSet<>();
        for(int ele: nums){
            min=Math.min(min,ele);
            max=Math.max(max,ele);
            s.add(ele);
        }
        List<Integer> l = new ArrayList<>();
        for(int i=min;i<max;i++){
            if(!s.contains(i)){
                l.add(i);
            }
        }
        return l;
    }
}