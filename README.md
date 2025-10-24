# TDE 3 - Ordenação 

Implementação de algoritmos de ordenação. Análise e comparação de seus desempenhos.

Como métrica de comparação foi levado em consideração a quantidade de iterações, quantidade de trocas de elementos e suas mudanças dependendo do tipo de vetor.


✦ O programa executa os algoritmos nos três vetores; aleátorio, ordenado e inverso. Cada algoritmo foi implementado em um arquivo individual, no final, ele mostra tabelas com os resultados e rankings de desempenho.


# Resultados e Conclusões

# Vetor 1 

| Algoritmo                          | Iterações | Trocas |
| ---------------------------------- | --------- | ------ |
| Comb Sort                          | 138       | 22     |
| Gnome Sort                         | 176       | 78     |
| Bucket Sort (insertion nos baldes) | 106       | 22     |
| Bubble Sort (flag)                 | 195       | 78     |
| Selection Sort                     | 209       | 18     |
| Cocktail Sort                      | 160       | 78     |

# Ranking por Trocas (Eficiência)
1º Selection Sort — 18

2º Comb Sort — 22

3º Bucket Sort — 22


# Ranking por Iterações (Desempenho)
1º Bucket Sort — 106

2º Comb Sort — 138


# Melhor desempenho geral: Bucket Sort e Comb Sort.

Vetor 2
| Algoritmo                          | Iterações | Trocas |
| ---------------------------------- | --------- | ------ |
| Comb Sort                          | 118       | 0      |
| Gnome Sort                         | 20        | 0      |
| Bucket Sort (insertion nos baldes) | 84        | 0      |
| Bubble Sort (flag)                 | 20        | 0      |
| Selection Sort                     | 209       | 0      |
| Cocktail Sort                      | 20        | 0      |

# Ranking (menos trocas)
Todos empataram (0 trocas).

Ranking (menos iterações)
1º Gnome Sort — 20
2º Bubble Sort (flag) — 20
3º Cocktail Sort — 20

Melhor desempenho geral: Gnome Sort, Bubble Sort e Cocktail Sort.

Vetor 3
| Algoritmo                          | Iterações | Trocas |
| ---------------------------------- | --------- | ------ |
| Comb Sort                          | 138       | 18     |
| Gnome Sort                         | 400       | 190    |
| Bucket Sort (insertion nos baldes) | 147       | 63     |
| Bubble Sort (flag)                 | 209       | 190    |
| Selection Sort                     | 209       | 10     |
| Cocktail Sort                      | 200       | 190    |

Ranking (menos trocas)
1º Selection Sort — 10
2º Comb Sort — 18
3º Bucket Sort — 63

Ranking (menos iterações)
1º Comb Sort — 138
2º Bucket Sort — 147

Melhor desempenho geral: Comb Sort.


| Vetores         | Melhor algoritmo                   | Razão                               |
| --------------- | ---------------------------------- | ----------------------------------- |
| Vetor aleatório | **Bucket Sort**                    | Poucas trocas e iterações           |
| Vetor ordenado  | **Gnome / Bubble / Cocktail Sort** | Detectam ordenação rápida           |
| Vetor inverso   | **Comb Sort**                      | Equilíbrio entre trocas e iterações |




