class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> l = new ArrayList<>();
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int len = lowLen; len <= highLen; len++) {
            for (int i = 0; i + len <= 9; i++) {
                int num = Integer.parseInt(s.substring(i, i + len));
                if (num >= low && num <= high) {
                    l.add(num);
                }
            }
        }

        return l;
    }
}