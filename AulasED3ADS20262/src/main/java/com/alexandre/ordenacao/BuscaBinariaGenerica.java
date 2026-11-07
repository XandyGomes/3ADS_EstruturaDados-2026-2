package com.alexandre.ordenacao;

/**
 * Busca Binária genérica, mesma lógica de
 * com.alexandre.aulased3ads20262.BuscaBinariaGenerica, num pacote separado
 * para poder ser importada e reaproveitada em outros trabalhos.
 *
 * ATENÇÃO: só funciona corretamente em um vetor já ORDENADO (crescente)
 * pelo mesmo critério do compareTo.
 *
 * @author Alexandre
 */
public class BuscaBinariaGenerica {

    public static <T extends Comparable<T>>
            int buscaBinariaGenerica(T[] vetor, T valorBusca) {
        int ini = 0;
        int fim = vetor.length - 1;

        while (ini <= fim) {
            int meio = (ini + fim) / 2;
            int comparacao = valorBusca.compareTo(vetor[meio]);
            if (comparacao == 0) {
                return meio;
            }
            if (comparacao > 0) {
                ini = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
}
