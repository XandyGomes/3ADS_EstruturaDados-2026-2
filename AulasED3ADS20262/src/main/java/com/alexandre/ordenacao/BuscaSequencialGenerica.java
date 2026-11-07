package com.alexandre.ordenacao;

/**
 * Versão genérica da Busca Sequencial, no mesmo espírito da evolução que já
 * existe nas aulas (com.alexandre.aulased3ads20262.BuscaSequencial ->
 * BuscaBinariaGenerica): usa Comparable para funcionar com qualquer tipo de
 * objeto, não só Integer/String. Não precisa do vetor ordenado.
 *
 * @author Alexandre
 */
public class BuscaSequencialGenerica {

    public static <T extends Comparable<T>>
            int buscaSequencialGenerica(T[] vetor, T valorBusca) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].compareTo(valorBusca) == 0) {
                return i;
            }
        }
        return -1;
    }
}
