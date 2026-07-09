class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int a[] = new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            a[i]=matrix[0][i]-'0';
        }
        int max=largestRectangleArea(a);
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    a[j]=0;
                }else{
                    a[j]++;
                }
            }
            max=Math.max(max,largestRectangleArea(a));
        }
        return max;
    }

    public int largestRectangleArea(int[] h) {
        int mx=0;
        int n=h.length;
        int[] ps=psei(h);
        int[] ns=nsei(h);

        for(int i=0;i<n;i++){
            int area=h[i]*(ns[i]-ps[i]-1);
            mx=Math.max(mx,area);
        }
        return mx;
    }

    int[] psei(int[] a){
        int n=a.length;
        int ans[]=new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&&a[i]<a[s.peek()]){
                ans[s.pop()]=i;
            }
            s.push(i);
        }
        return ans;
    }

    int[] nsei(int[] a){
        int n=a.length;
        int ans[]=new int[n];
        Arrays.fill(ans,n);
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty()&&a[i]<a[s.peek()]){
                ans[s.pop()]=i;
            }
            s.push(i);
        }
        return ans;
    }
}