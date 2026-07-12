class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] a= arr.clone();
        Arrays.sort(a);
        Map<Integer,Integer> m = new HashMap<>();
        int c=0;
        for(int ele: a){
            if(!m.containsKey(ele)){
                m.put(ele,++c);
            }
        }
        for(int i=0;i<arr.length;i++){
            a[i]=m.get(arr[i]);
        }
        return a;
    }
}