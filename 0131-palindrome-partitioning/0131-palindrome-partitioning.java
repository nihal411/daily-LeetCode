class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s,new ArrayList<>(),ans);
        return ans;
    }
    void helper(String s,List<String> l,List<List<String>> ans){
        if(s.length()==0){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<s.length();i++){
            String p = s.substring(0,i+1);
            if(palindrome(p)){
                l.add(p);
                helper(s.substring(i+1),l,ans);
                l.remove(l.size()-1);
            }
        }
    }
    boolean palindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}