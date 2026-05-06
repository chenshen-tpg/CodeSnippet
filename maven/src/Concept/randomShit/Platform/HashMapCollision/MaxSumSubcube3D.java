package randomShit.Platform.HashMapCollision;

public class MaxSumSubcube3D {
    // arr: 3D array, k, l, m: window sizes
    public static int maxSumSubcube(int[][][] arr, int k, int l, int m) {
        int n = arr.length;
        int p = arr[0].length;
        int q = arr[0][0].length;
        int[][][] prefix = new int[n + 1][p + 1][q + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= p; j++) {
                for (int k_ = 1; k_ <= q; k_++) {
                    prefix[i][j][k_] = arr[i - 1][j - 1][k_ - 1] + prefix[i - 1][j][k_] + prefix[i][j - 1][k_]
                            + prefix[i][j][k_ - 1] - prefix[i - 1][j - 1][k_] - prefix[i - 1][j][k_ - 1] - prefix[i][j - 1][k_ - 1]
                            + prefix[i - 1][j - 1][k_ - 1];
                }
            }
        }
        int maxSum = Integer.MIN_VALUE;
        // Slide window
        for (int i = k; i <= n; i++) {
            for (int j = l; j <= p; j++) {
                for (int k_ = m; k_ <= q; k_++) {
                    int total = prefix[i][j][k_]
                            - prefix[i - k][j][k_]
                            - prefix[i][j - l][k_]
                            - prefix[i][j][k_ - m]
                            + prefix[i - k][j - l][k_]
                            + prefix[i - k][j][k_ - m]
                            + prefix[i][j - l][k_ - m]
                            - prefix[i - k][j - l][k_ - m];
                    maxSum = Math.max(maxSum, total);
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][][] arr = {
                {{1, 2}, {3, 4}},
                {{5, 6}, {7, 8}}
        };
        System.out.println(maxSumSubcube(arr, 2, 2, 2)); // Output: 36
    }
}

