l = [2, 9, 6, 8, 3, 12, 22, 35, 18, 1, 6]

def qtde(num, l):
    if len(l) == 0:
        return 0
    elif l[0] == num:
        return 1 + qtde(num, l[1:])
    else:
        return qtde(num, l[1:])
            
print(l)
print(qtde(6, l))