def fibonacci(n):
    if n == 1 or n ==2:
        return 1
    else:
        a = fibonacci(n - 1)
        b = fibonacci(n -2)
    return a + b

print(fibonacci(10))