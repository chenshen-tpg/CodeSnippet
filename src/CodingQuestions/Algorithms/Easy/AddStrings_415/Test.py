def addStrings(num1, num2):
    res = []
    i, j = len(num1) -1, len(num2) -1
    cur = 0;
    while i >= 0 or j >= 0 or cur != 0:
        dig1 = int(num1[i]) if i>=0 else 0
        dig2 = int(num2[j]) if j>=0 else 0
        total = dig1 + dig2 + cur
        res.append(str(total % 10))
        cur = total // 10
        i -= 1
        j -=1
    return ''.join(res[::-1])


print(addStrings("11", "123"))  # Output: "134"