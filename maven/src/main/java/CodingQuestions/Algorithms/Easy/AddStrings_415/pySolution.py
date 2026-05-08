def addStrings(num1, num2):
    res = []
    i, j = len(num1) - 1, len(num2) - 1
    carry = 0
    while i >= 0 or j >= 0 or carry:
        digit1 = int(num1[i]) if i >= 0 else 0
        digit2 = int(num2[j]) if j >= 0 else 0
        total = digit1 + digit2 + carry
        res.append(str(total % 10))
        carry = total // 10
        i -= 1
        j -= 1
    return ''.join(res[::-1])

# Example usage:
print(addStrings("11", "123"))  # Output: "134"