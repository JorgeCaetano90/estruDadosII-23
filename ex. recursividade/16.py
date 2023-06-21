import random

def k_esimo_maior(lista, k):
    if len(lista) == 1:
        return lista[0]
    else:
        pivo = random.choice(lista)
        maiores = [x for x in lista if x > pivo]
        if len(maiores) >= k:
            return k_esimo_maior(maiores, k)
        else:
            menores = [x for x in lista if x < pivo]
            return k_esimo_maior(menores, k - len(maiores))
          
lista = [2, 4, 6, 7, 3, 9, 10, 1]
k = 5
print(k_esimo_maior(lista, k))