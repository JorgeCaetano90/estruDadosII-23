def mmc(x, y):
    def mdc(x, y):
        if y == 0:
            return x
        else:
            return mdc(y, x % y)
    return (x*y) // mdc(x, y)
  
print(mmc(4, 6))