def apply_operations(nums):
    n = len(nums)
    for i in range(1, n):
        if nums[i] == nums[i - 1]:
            nums[i - 1] *= 2
            nums[i] = 0
    k = 0
    for i in range(n):
        if nums[i] != 0:
            nums[k] = nums[i]
            k += 1
    for i in range(k, n):
        nums[i] = 0
    return nums


if __name__ == "__main__":
    print(apply_operations([1, 2, 2, 1, 1, 0]))
