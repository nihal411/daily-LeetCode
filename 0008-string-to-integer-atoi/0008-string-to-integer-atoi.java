class Solution {
    public int myAtoi(String s) {
        long ans =0;
        int i=0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        if(i==s.length()) return 0;
        int pos =1;
        if(s.charAt(i)=='-'){
            pos=-1;
            i++;
        }else if(s.charAt(i)=='+'){
            i++;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int num = s.charAt(i)-'0';
            ans=ans*10+num;
            if(ans * pos <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if(ans * pos >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            i++;
        }
        return (int)(ans*pos);
    }
}