l = [2, 9, 6, 8, 3, 12, 22, 35, 18]

def maior_valor(l):
    if len(l) == 1:
        return l[0]
    else:
        return max(l[0], maior_valor(l[1:]))
    
print(l)
print(maior_valor(l))
