class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long x=1;
        long i=0;
        String s = new StringBuilder(n+"").reverse().toString();
        for(char ch: s.toCharArray()){
            if(ch!='0'){
                int ele=ch-'0';
                sum+=ele;
                i+=x*ele;
                x=x*10;
            }
        }
        
        return i*sum;
    }
}