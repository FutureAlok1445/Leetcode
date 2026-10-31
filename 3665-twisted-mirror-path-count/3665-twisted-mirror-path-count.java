class Solution {
    public int uniquePaths(int[][] grid) {

        // Grid ki rows aur columns
        int m = grid.length;
        int n = grid[0].length;

        // Large answer ko control mein rakhne ke liye
        int mod = 1000000007;

        // Right se aane wale paths count
        int[][] right = new int[m][n];

        // Down se aane wale paths count
        int[][] down = new int[m][n];

        // Starting point par 1 path hai
        right[0][0] = 1;

        // Har row check karo
        for (int i = 0; i < m; i++) {

            // Har column check karo
            for (int j = 0; j < n; j++) {

                // Agar cell normal hai (0)
                if (grid[i][j] == 0) {

                    // Dono taraf se aane wale paths add karo
                    int total = (right[i][j] + down[i][j]) % mod;

                    // Robot right ja sakta hai
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + total) % mod;
                    }

                    // Robot down ja sakta hai
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + total) % mod;
                    }

                } 
                // Agar cell mirror hai (1)
                else {

                    // Right se aaya toh down bhejo
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + right[i][j]) % mod;
                    }

                    // Down se aaya toh right bhejo
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + down[i][j]) % mod;
                    }
                }
            }
        }

        // Destination tak pahunchne wale total paths
        return (right[m - 1][n - 1] + down[m - 1][n - 1]) % mod;
    }
}