from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def averageOfLevels(root):
    ans = []
    queue = deque([root])
    while queue:
        level_sum = 0
        size = len(queue)
        for _ in range(size):
            node = queue.popleft()
            level_sum += node.val
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        ans.append(level_sum / size)
    return ans

# Example usage:
root = TreeNode(3)
n1 = TreeNode(9)
n2 = TreeNode(20)
n3 = TreeNode(15)
n4 = TreeNode(7)
root.left = n1
root.right = n2
n2.left = n3
n2.right = n4

print(averageOfLevels(root))  # Output: [3.0, 14.5, 11.0]