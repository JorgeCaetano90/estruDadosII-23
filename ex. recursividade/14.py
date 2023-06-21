def caminho_mais_curto(labirinto, origem, destino):
    # Função auxiliar para verificar se um ponto é válido
    def ponto_valido(ponto):
        i, j = ponto
        linhas, colunas = len(labirinto), len(labirinto[0])
        return (0 <= i < linhas) and (0 <= j < colunas) and (labirinto[i][j] != 1)

    # Começa a busca em largura
    fila = [(origem, [origem])]
    visitados = set()
    while fila:
        ponto, caminho = fila.pop(0)
        if ponto == destino:
            return caminho
        if ponto not in visitados:
            visitados.add(ponto)
            i, j = ponto
            possiveis_movimentos = [(i+1, j), (i-1, j), (i, j+1), (i, j-1)]
            for proximo_ponto in possiveis_movimentos:
                if ponto_valido(proximo_ponto):
                    novo_caminho = list(caminho)
                    novo_caminho.append(proximo_ponto)
                    fila.append((proximo_ponto, novo_caminho))
    # Se a fila ficou vazia, o labirinto não tem solução
    return None