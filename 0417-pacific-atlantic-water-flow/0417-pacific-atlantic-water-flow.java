class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        Queue<int[]> pac = new LinkedList<>();
        Queue<int[]> atl = new LinkedList<>();
        boolean[][] p = new boolean[n][m];
        boolean[][] a = new boolean[n][m];
        for(int i=0;i<n;i++){
            pac.add(new int[]{i,0});
            p[i][0]=true;
        }
        for(int i=0;i<m;i++){
            pac.add(new int[]{0,i});
            p[0][i]=true;
        }
        for(int i=0;i<n;i++){
            atl.add(new int[]{i,m-1});
            a[i][m-1]=true;
        }
        for(int i=0;i<m;i++){
            atl.add(new int[]{n-1,i});
            a[n-1][i]=true;
        }
        bfs(pac,p,heights);
        bfs(atl,a,heights);
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(p[i][j] && a[i][j]){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    l.add(ans);
                }
            }
        }
        return l;
    }
    void bfs(Queue<int[]> q, boolean[][] b,int[][] a){
        int[] xi = {1,0,-1,0};
        int[] xj = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i=0;i<4;i++){
                int nx = p[0]+xi[i];
                int ny = p[1]+xj[i];
                if(nx>=0 && ny>=0 && nx<a.length && ny<a[0].length && !b[nx][ny] && a[p[0]][p[1]]<=a[nx][ny]){
                    q.add(new int[]{nx,ny});
                    b[nx][ny]=true;
                }
            }
        }
    }
}