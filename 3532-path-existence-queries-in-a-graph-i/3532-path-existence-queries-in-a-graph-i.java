class Solution {
    public boolean[] pathExistenceQueries(int n, int[] a, int max, int[][] q) {
        int l=q.length;
        boolean[] b=new boolean[l];
        for(int i=0;i<l;i++){
            int f=-1;
            if(q[i][0]<=q[i][1]){
                for(int j=q[i][0];j<q[i][1];j++){
                    if(Math.abs(a[j]-a[j+1])<=max) continue;
                    else{
                        f=0;
                        break;
                    }
                }
            }
            else{
                for(int j=q[i][0];j>q[i][1];j--){
                    if(Math.abs(a[j]-a[j-1])<=max) continue;
                    else{
                        f=0;
                        break;
                    }
                }
            }
            if(f==0) b[i]=false;
            else b[i]=true;
        }
        return b;
    }
}