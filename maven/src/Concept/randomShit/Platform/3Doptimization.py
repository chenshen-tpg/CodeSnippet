def max_sum_subcube(arr, k, l, m):
    n, p, q = len(arr), len(arr[0]), len(arr[0][0])
    # Compute 3D prefix sum
    prefix = [[[0]*(q+1) for _ in range(p+1)] for _ in range(n+1)]
    for i in range(1, n+1):
        for j in range(1, p+1):
            for k_ in range(1, q+1):
                prefix[i][j][k_] = (
                        arr[i-1][j-1][k_-1]
                        + prefix[i-1][j][k_]
                        + prefix[i][j-1][k_]
                        + prefix[i][j][k_-1]
                        - prefix[i-1][j-1][k_]
                        - prefix[i-1][j][k_-1]
                        - prefix[i][j-1][k_-1]
                        + prefix[i-1][j-1][k_-1]
                )
    max_sum = float('-inf')
    # Slide window
    for i in range(k, n+1):
        for j in range(l, p+1):
            for k_ in range(m, q+1):
                total = (
                        prefix[i][j][k_]
                        - prefix[i-k][j][k_]
                        - prefix[i][j-l][k_]
                        - prefix[i][j][k_-m]
                        + prefix[i-k][j-l][k_]
                        + prefix[i-k][j][k_-m]
                        + prefix[i][j-l][k_-m]
                        - prefix[i-k][j-l][k_-m]
                )
                max_sum = max(max_sum, total)
    return max_sum

# Example usage:
arr = [
    [[1,2],[3,4]],
    [[5,6],[7,8]]
]
print(max_sum_subcube(arr, 2, 2, 2))  # Output: 36 (sum of all elements)