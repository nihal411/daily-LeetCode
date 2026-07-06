class Solution{
    List<List<String>> ans=new ArrayList<>();
    void helper(char[][] board,int row){
        if(row==board.length){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(check(board,row,col)){
                board[row][col]='Q';
                helper(board,row+1);
                board[row][col]='.';
            }
        }
    }
    boolean check(char[][] a,int i,int j){
        for(int k=0;k<a.length;k++){
            if(a[k][j]=='Q'){
                return false;
            }
        }
        for(int k=0;k<a.length;k++){
            if(a[i][k]=='Q'){
                return false;
            }
        }
        int c=i,b=j;
        while(c<a.length&&b<a.length){
            if(a[c++][b++]=='Q'){
                return false;
            }
        }
        c=i;
        b=j;
        while(c>=0&&b>=0){
            if(a[c--][b--]=='Q'){
                return false;
            }
        }
        c=i;
        b=j;
        while(c>=0&&b<a.length){
            if(a[c--][b++]=='Q'){
                return false;
            }
        }
        c=i;
        b=j;
        while(c<a.length&&b>=0){
            if(a[c++][b--]=='Q'){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n){
        char[][] a=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]='.';
            }
        }
        helper(a,0);
        return ans;
    }
}