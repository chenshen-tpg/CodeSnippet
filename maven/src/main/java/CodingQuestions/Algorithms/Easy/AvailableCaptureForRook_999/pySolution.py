def numRookCaptures(board):
    # Find the rook's position
    for i in range(8):
        for j in range(8):
            if board[i][j] == 'R':
                x, y = i, j
                break

    def find(dx, dy):
        nx, ny = x + dx, y + dy
        while 0 <= nx < 8 and 0 <= ny < 8:
            if board[nx][ny] == 'B':
                return 0
            if board[nx][ny] == 'p':
                return 1
            nx += dx
            ny += dy
        return 0

    # Check all four directions
    return find(0, 1) + find(1, 0) + find(0, -1) + find(-1, 0)

# Example usage:
board = [
    [".",".",".",".",".",".",".","."],
    [".",".",".","p",".",".",".","."],
    [".",".",".","R",".",".",".","p"],
    [".",".",".",".",".",".",".","."],
    [".",".",".",".",".",".",".","."],
    [".",".",".","p",".",".",".","."],
    [".",".",".",".",".",".",".","."],
    [".",".",".",".",".",".",".","."]
]
print(numRookCaptures(board))  # Output: 3