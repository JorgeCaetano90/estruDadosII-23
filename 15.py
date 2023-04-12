l = [2, 9, 6, 8, 3, 12, 22, 35, 18, 1, 4]

def mediana(l):
    if len(l) == 0:
        return 0
    else:
        l_order = sorted(l)
        meio = len(l_order) // 2
        return l_order[meio]
            
l_order = sorted(l)

print(l)
print(l_order)
print(mediana(l))