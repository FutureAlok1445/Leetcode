class Solution {
    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int mod = 1000000007;

        int[][] left = new int[m][n];
        int[][] top = new int[m][n];

        // Starting point
        left[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Current cell tak total ways
                int ways = (left[i][j] + top[i][j]) % mod;

                // Normal cell
                if (grid[i][j] == 0) {

                    // Move right
                    if (j + 1 < n) {
                        left[i][j + 1] += ways;
                        left[i][j + 1] %= mod;
                    }

                    // Move down
                    if (i + 1 < m) {
                        top[i + 1][j] += ways;
                        top[i + 1][j] %= mod;
                    }

                } else {

                    // Mirror: left se aaye toh down
                    if (i + 1 < m) {
                        top[i + 1][j] += left[i][j];
                        top[i + 1][j] %= mod;
                    }

                    // Mirror: top se aaye toh right
                    if (j + 1 < n) {
                        left[i][j + 1] += top[i][j];
                        left[i][j + 1] %= mod;
                    }
                }
            }
        }

        return (left[m - 1][n - 1] + top[m - 1][n - 1]) % mod;
    }
}