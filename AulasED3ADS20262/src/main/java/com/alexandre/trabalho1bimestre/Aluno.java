package com.alexandre.trabalho1bimestre;

/**
 * Classe que representa o Aluno (objeto heterogêneo armazenado no Array).
 *
 * @author Alexandre
 */
public class Aluno {

    private String nome;
    private int ra;
    private int idade;
    private String sexo;
    private double media;
    private String resultado;

    public Aluno(String nome, int ra, int idade, String sexo, double media) {
        this.nome = nome;
        this.ra = ra;
        this.idade = idade;
        this.sexo = sexo;
        this.media = media;
        calcularResultado();
    }

    // Regra de negócio: preenche o campo RESULTADO de acordo com a média.
    public void calcularResultado() {
        if (media >= 6.0) {
            resultado = "Aprovado";
        } else {
            resultado = "Reprovado";
        }
    }

    public String getNome() {
        return nome;
    }

    public int getRa() {
        return ra;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public double getMedia() {
        return media;
    }

    public String getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + " | RA: " + ra
                + " | Idade: " + idade
                + " | Sexo: " + sexo
                + " | Média: " + media
                + " | Resultado: " + resultado;
    }
}
