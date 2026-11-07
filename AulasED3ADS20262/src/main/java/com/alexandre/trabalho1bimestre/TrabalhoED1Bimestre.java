package com.alexandre.trabalho1bimestre;

import com.alexandre.ordenacao.BubbleSort;
import com.alexandre.ordenacao.BuscaBinariaGenerica;
import com.alexandre.ordenacao.BuscaSequencialGenerica;
import com.alexandre.ordenacao.MergeSort;
import com.alexandre.ordenacao.SelectionSort;
import java.util.Scanner;

/**
 * Trabalho 1º Bimestre - Estrutura de Dados
 * Cadastro de alunos em um Array de Objetos, reaproveitando (por
 * importação) as classes de ordenação e busca vistas em aula: Bubble Sort,
 * Selection Sort, Merge Sort, Busca Sequencial e Busca Binária.
 *
 * Obs.: o enunciado original só pede as opções 1 a 4 (com Bubble ou
 * Selection Sort). As opções 5 e 6 foram incluídas a mais aqui só para
 * também exercitar Merge Sort e as buscas do conteúdo programático.
 *
 * @author Alexandre
 */
public class TrabalhoED1Bimestre {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Quantos alunos você deseja cadastrar no máximo? ");
        int max = sc.nextInt();

        Aluno[] alunos = new Aluno[max];
        int qtdCadastrados = 0;

        int opcao;
        do {
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine(); // limpa o \n que fica no buffer após o nextInt

            switch (opcao) {
                case 1:
                    qtdCadastrados = cadastrarAlunos(alunos, qtdCadastrados);
                    break;
                case 2:
                    relatorioPorNome(alunos, qtdCadastrados);
                    break;
                case 3:
                    relatorioPorRA(alunos, qtdCadastrados);
                    break;
                case 4:
                    relatorioAprovados(alunos, qtdCadastrados);
                    break;
                case 5:
                    buscarPorNome(alunos, qtdCadastrados);
                    break;
                case 6:
                    buscarPorRA(alunos, qtdCadastrados);
                    break;
                case 7:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 7);
    }

    public static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Cadastrar Alunos");
        System.out.println("2 - Relatório por Nome (Crescente)");
        System.out.println("3 - Relatório por RA (Decrescente)");
        System.out.println("4 - Relatório de Aprovados (Crescente por Nome)");
        System.out.println("5 - Buscar Aluno por Nome (Busca Sequencial)");
        System.out.println("6 - Buscar Aluno por RA (Busca Binária)");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // 1 - Cadastrar Alunos: lê os dados via Scanner e guarda no Array
    public static int cadastrarAlunos(Aluno[] alunos, int qtdCadastrados) {

        if (qtdCadastrados >= alunos.length) {
            System.out.println("O array já está cheio! Não é possível cadastrar mais alunos.");
            return qtdCadastrados;
        }

        System.out.print("Quantos alunos deseja cadastrar agora? ");
        int qtd = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtd; i++) {

            if (qtdCadastrados >= alunos.length) {
                System.out.println("Array cheio! Cadastro interrompido.");
                break;
            }

            System.out.println("\n--- Cadastro do aluno " + (qtdCadastrados + 1) + " ---");

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("RA: ");
            int ra = sc.nextInt();

            System.out.print("Idade: ");
            int idade = sc.nextInt();
            sc.nextLine();

            System.out.print("Sexo (M/F): ");
            String sexo = sc.nextLine();

            System.out.print("Média: ");
            double media = sc.nextDouble();
            sc.nextLine();

            alunos[qtdCadastrados] = new Aluno(nome, ra, idade, sexo, media);
            qtdCadastrados++;
        }

        return qtdCadastrados;
    }

    // 2 - Relatório por Nome (Crescente) usando o MergeSort importado
    // (mais eficiente que Bubble/Selection para vetores grandes: O(n log n))
    public static void relatorioPorNome(Aluno[] alunos, int qtdCadastrados) {

        if (qtdCadastrados == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        AlunoPorNome[] embrulhados = embrulharPorNome(alunos, qtdCadastrados);

        MergeSort.mergeSort(embrulhados);

        System.out.println("\n=== Relatório por Nome (Crescente) - Merge Sort ===");
        for (AlunoPorNome item : embrulhados) {
            System.out.println(item);
        }
    }

    // 3 - Relatório por RA (Decrescente): ordena crescente com SelectionSort
    // e imprime de trás para frente (assim reaproveita o mesmo Comparable
    // "natural" que a Busca Binária por RA também usa)
    public static void relatorioPorRA(Aluno[] alunos, int qtdCadastrados) {

        if (qtdCadastrados == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        AlunoPorRA[] embrulhados = embrulharPorRA(alunos, qtdCadastrados);

        SelectionSort.selectionSort(embrulhados);

        System.out.println("\n=== Relatório por RA (Decrescente) - Selection Sort ===");
        for (int i = embrulhados.length - 1; i >= 0; i--) {
            System.out.println(embrulhados[i]);
        }
    }

    // 4 - Relatório de Aprovados (Crescente por Nome), com Bubble Sort
    public static void relatorioAprovados(Aluno[] alunos, int qtdCadastrados) {

        if (qtdCadastrados == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        // primeiro conta quantos aprovados existem, para montar o array certo
        int qtdAprovados = 0;
        for (int i = 0; i < qtdCadastrados; i++) {
            if (alunos[i].getResultado().equals("Aprovado")) {
                qtdAprovados++;
            }
        }

        if (qtdAprovados == 0) {
            System.out.println("Nenhum aluno aprovado até o momento.");
            return;
        }

        AlunoPorNome[] aprovados = new AlunoPorNome[qtdAprovados];
        int pos = 0;
        for (int i = 0; i < qtdCadastrados; i++) {
            if (alunos[i].getResultado().equals("Aprovado")) {
                aprovados[pos] = new AlunoPorNome(alunos[i]);
                pos++;
            }
        }

        BubbleSort.bubbleSort(aprovados);

        System.out.println("\n=== Relatório de Aprovados (Crescente por Nome) - Bubble Sort ===");
        for (AlunoPorNome item : aprovados) {
            System.out.println(item);
        }
    }

    // 5 - Buscar Aluno por Nome usando Busca Sequencial (não precisa ordenar)
    public static void buscarPorNome(Aluno[] alunos, int qtdCadastrados) {

        if (qtdCadastrados == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.print("Nome a buscar: ");
        String nomeBuscado = sc.nextLine();

        AlunoPorNome[] embrulhados = embrulharPorNome(alunos, qtdCadastrados);
        AlunoPorNome chave = new AlunoPorNome(nomeBuscado);

        int indice = BuscaSequencialGenerica.buscaSequencialGenerica(embrulhados, chave);

        if (indice == -1) {
            System.out.println("Aluno não encontrado.");
        } else {
            System.out.println("Encontrado: " + embrulhados[indice]);
        }
    }

    // 6 - Buscar Aluno por RA usando Busca Binária (exige o vetor ordenado
    // crescente, por isso ordenamos com MergeSort antes de buscar)
    public static void buscarPorRA(Aluno[] alunos, int qtdCadastrados) {

        if (qtdCadastrados == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.print("RA a buscar: ");
        int raBuscado = sc.nextInt();
        sc.nextLine();

        AlunoPorRA[] embrulhados = embrulharPorRA(alunos, qtdCadastrados);
        MergeSort.mergeSort(embrulhados);

        AlunoPorRA chave = new AlunoPorRA(raBuscado);

        int indice = BuscaBinariaGenerica.buscaBinariaGenerica(embrulhados, chave);

        if (indice == -1) {
            System.out.println("Aluno não encontrado.");
        } else {
            System.out.println("Encontrado: " + embrulhados[indice]);
        }
    }

    private static AlunoPorNome[] embrulharPorNome(Aluno[] alunos, int qtdCadastrados) {
        AlunoPorNome[] embrulhados = new AlunoPorNome[qtdCadastrados];
        for (int i = 0; i < qtdCadastrados; i++) {
            embrulhados[i] = new AlunoPorNome(alunos[i]);
        }
        return embrulhados;
    }

    private static AlunoPorRA[] embrulharPorRA(Aluno[] alunos, int qtdCadastrados) {
        AlunoPorRA[] embrulhados = new AlunoPorRA[qtdCadastrados];
        for (int i = 0; i < qtdCadastrados; i++) {
            embrulhados[i] = new AlunoPorRA(alunos[i]);
        }
        return embrulhados;
    }
}
