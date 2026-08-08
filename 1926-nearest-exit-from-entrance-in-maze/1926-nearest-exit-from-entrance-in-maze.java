class Solution {
    public int nearestExit(char[][] maze, int[] e) {
        int xi[]= {-1,0,1,0};
        int xj[]= {0,1,0,-1};
        Queue<Pair> q = new LinkedList<>();
        int n = maze.length;
        int m = maze[0].length;
        boolean v[][] = new boolean[n][m];
        q.add(new Pair(e[0],e[1],0));
        v[e[0]][e[1]]=true;
        while(!q.isEmpty()){
            Pair p= q.remove();
            int x = p.i;
            int y = p.j;
            int d = p.d;
            if((x==0 || y==0 || x==n-1 || y==m-1)&& (x!=e[0] || y!=e[1])){
                return d;
            }
            for(int i=0;i<4;i++){
                if(x+xi[i]>=0 && x+xi[i]<n && y+xj[i]>=0 && y+xj[i]<m && !v[x+xi[i]][y+xj[i]] && maze[x+xi[i]][y+xj[i]]!='+'){
                    q.add(new Pair(x+xi[i],y+xj[i],d+1));
                    v[x+xi[i]][y+xj[i]]=true;
                }
            }
            
        }
        return -1;
        
    }
}
class Pair{
    int i;
    int j;
    int d;
    public Pair(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}