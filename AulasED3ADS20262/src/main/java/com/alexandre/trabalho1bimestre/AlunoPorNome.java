package com.alexandre.trabalho1bimestre;

/**
 * "Casca" em volta do Aluno só para poder usar as classes prontas de
 * ordenação/busca (BubbleSort, MergeSort, BuscaSequencialGenerica, que
 * exigem Comparable) comparando pelo NOME, sem precisar mexer no Aluno nem
 * nessas classes já prontas.
 *
 * Também serve como "chave de busca": para procurar um aluno pelo nome,
 * cria-se um AlunoPorNome só com o nome (sem Aluno associado).
 *
 * @author Alexandre
 */
public class AlunoPorNome implements Comparable<AlunoPorNome> {

    private Aluno aluno;
    private String nomeChave;

    // usado para embrulhar um aluno já cadastrado (ordenar/exibir)
    public AlunoPorNome(Aluno aluno) {
        this.aluno = aluno;
    }

    // usado só como chave de busca (não representa um aluno cadastrado)
    public AlunoPorNome(String nomeBuscado) {
        this.nomeChave = nomeBuscado;
    }

    public Aluno getAluno() {
        return aluno;
    }

    private String getNomeParaComparar() {
        return aluno != null ? aluno.getNome() : nomeChave;
    }

    @Override
    public int compareTo(AlunoPorNome outro) {
        return this.getNomeParaComparar().compareToIgnoreCase(outro.getNomeParaComparar());
    }

    @Override
    public String toString() {
        return aluno != null ? aluno.toString() : nomeChave;
    }
}
