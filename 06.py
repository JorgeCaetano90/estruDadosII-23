def pot(x, y):
    if y == 1:
        return x
    else:
        return x * pot(x, y-1)

print(pot(7, 5))