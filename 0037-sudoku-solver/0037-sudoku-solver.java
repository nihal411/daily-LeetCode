class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
    boolean helper(char[][] a,int i,int j){
        if(i==9){
            return true;
        }
        int newr = i;
        int newc = j+1;
        if(newc==9){
            newc=0;
            newr+=1;
        }
        if(a[i][j]!='.'){
            return helper(a,newr,newc);
        }
        for(char k='1';k<='9';k++){
            if(issafe(a,k,i,j)){
                a[i][j]=k;
                if(helper(a,newr,newc)){
                    return true;
                }
                a[i][j]='.';
            }
        }
        return false;
        
    }
    boolean issafe(char[][] ar,int k,int a,int b){
        for(int i=0;i<9;i++){
            if(ar[a][i]==k){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(ar[i][b]==k){
                return false;
            }
        }
        int newr = (a/3)*3;
        int newc = (b/3)*3;
        for(int i=newr;i<=newr+2;i++){
            for(int j=newc;j<=newc+2;j++){
                if(ar[i][j]==k){
                    return false;
                }
            }
        }
        return true;
    }
}