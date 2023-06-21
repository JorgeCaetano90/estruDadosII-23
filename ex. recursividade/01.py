def fatorial(n):
    j = 1
    for i in range(1, n+1):
        j = j * i
    return j

print(fatorial(5))