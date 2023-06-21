matriz = [[2, 9, 6],
          [8, 3, 12],
          [22, 35, 18]]

def soma_matriz(matriz):
    if isinstance(matriz, int):
        return 0
    else:
        return sum(soma_matriz(submatriz) for submatriz in matriz)

print(soma_matriz(matriz))

