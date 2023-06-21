l = [3, -6, 5, 7, -2, 5, -4, 1]

def sub_lista_max(l):
    if len(l) == 1:
        return l[0]
    else:
        max_sub_lista = sub_lista_max(l[1:])
        return max(l[0], l[0] + max_sub_lista)

print(sub_lista_max(l))