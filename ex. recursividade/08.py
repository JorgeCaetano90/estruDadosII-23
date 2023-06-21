l = [2, 9, 6, 8, 3, 12, 22, 35, 18, 1]

def menor_valor(l):
    if len(l) == 1:
        return l[0]
    else:
        return min(l[0], menor_valor(l[1:]))
    
print(l)
print(menor_valor(l))