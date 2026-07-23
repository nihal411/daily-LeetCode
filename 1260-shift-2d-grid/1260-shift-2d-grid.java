class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> l = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;

        int[] a = new int[n * m];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[idx++] = grid[i][j];
            }
        }

        int sz = n * m;
        k %= sz;

        helper(a, 0, sz - 1);
        helper(a, 0, k - 1);
        helper(a, k, sz - 1);

        idx = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                ans.add(a[idx++]);
            }
            l.add(ans);
        }

        return l;
    }

    private void helper(int[] a, int left, int right) {
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
}