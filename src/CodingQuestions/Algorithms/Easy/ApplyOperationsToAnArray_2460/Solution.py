
def applyOperations(nums):
    k = 0
    n = len(nums)
    for i in range(1, n):
        if nums[i] == nums[i - 1]:
            nums[i - 1] *= 2
            nums[i] = 0
    for i in range(n):
        if nums[i] != 0:
            nums[k] = nums[i]
            k += 1
    for i in range(k, n):
        nums[i] = 0
    return nums

# Example usage:
print(applyOperations([1,2,2,1,1,0]))  # Output: [1, 4, 2, 0, 0, 0]