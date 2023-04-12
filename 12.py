def combsoma(lista, soma):
    if soma == 0:
        return []
    elif len(lista) == 0:
        return None
    else:
        incluir = combsoma(lista[1:], soma - lista[0])
        if incluir is not None:
            return [lista[0]] + incluir
        else:
            return combsoma(lista[1:], soma)

print(combsoma([1, 2, 3, 4, 5], 7))