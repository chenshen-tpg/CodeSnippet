def rotate_the_box(boxGrid):
    m = len(boxGrid)
    n = len(boxGrid[0])
    # Step 1: Rotate the box 90 degrees clockwise
    rotated = [['' for _ in range(m)] for _ in range(n)]
    for i in range(m):
        for j in range(n):
            rotated[j][m - 1 - i] = boxGrid[i][j]

    # Step 2: Simulate gravity for each column
    for j in range(m):
        empty_row = n - 1
        for i in range(n - 1, -1, -1):
            if rotated[i][j] == '*':
                empty_row = i - 1
            elif rotated[i][j] == '#':
                rotated[i][j] = '.'
                rotated[empty_row][j] = '#'
                empty_row -= 1
    return rotated

# Example usage:
boxGrid = [
    ['#', '#', '*', '.', '*', '.'],
    ['#', '#', '#', '*', '.', '.'],
    ['#', '#', '#', '.', '#', '.']
]
result = rotate_the_box(boxGrid)
for row in result:
    print(''.join(row))