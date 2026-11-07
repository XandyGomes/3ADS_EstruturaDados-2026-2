package com.alexandre.trabalho1bimestre;

/**
 * "Casca" em volta do Aluno para comparar pelo RA (ordem CRESCENTE, natural).
 * Serve tanto para ordenar (SelectionSort/MergeSort) quanto como "chave de
 * busca" para a Busca Binária (que exige o vetor ordenado crescente).
 *
 * Para o relatório "por RA decrescente", basta ordenar crescente com essa
 * classe e depois imprimir o vetor de trás pra frente.
 *
 * @author Alexandre
 */
public class AlunoPorRA implements Comparable<AlunoPorRA> {

    private Aluno aluno;
    private Integer raChave;

    // usado para embrulhar um aluno já cadastrado (ordenar/exibir)
    public AlunoPorRA(Aluno aluno) {
        this.aluno = aluno;
    }

    // usado só como chave de busca (não representa um aluno cadastrado)
    public AlunoPorRA(int raBuscado) {
        this.raChave = raBuscado;
    }

    public Aluno getAluno() {
        return aluno;
    }

    private int getRaParaComparar() {
        return aluno != null ? aluno.getRa() : raChave;
    }

    @Override
    public int compareTo(AlunoPorRA outro) {
        return this.getRaParaComparar() - outro.getRaParaComparar();
    }

    @Override
    public String toString() {
        return aluno != null ? aluno.toString() : "RA " + raChave;
    }
}
