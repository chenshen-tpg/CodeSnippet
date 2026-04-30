def is_armstrong(n):
    length = len(str(n))
    ans = 0
    cal = n
    while cal > 0:
        digit = cal % 10
        ans += digit ** length
        cal //= 10
    return ans == n

# Example usage:
print(is_armstrong(153))  # Output: True
print(is_armstrong(123))  # Output: False


def is_armstrongNew(n):
    digits = [int(d) for d in str(n)]
    length = len(digits)
    # Precompute powers for digits 0-9
    pow_table = [d ** length for d in range(10)]
    return sum(pow_table[d] for d in digits) == n

# Example usage:
print(is_armstrong(153))  # True
print(is_armstrong(9474)) # True
print(is_armstrong(123))  # False