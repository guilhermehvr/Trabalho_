package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n===== Sistema de Produtos =====");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Consultar Produto");
            System.out.println("4. Editar Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    adicionarProduto(produtos, scanner);
                    break;
                case 2:
                    excluirProduto(produtos, scanner);
                    break;
                case 3:
                    consultarProduto(produtos, scanner);
                    break;
                case 4:
                    editarProduto(produtos, scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void adicionarProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.println("\n===== Adicionar Produto =====");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade em Estoque: ");
        int quantidadeEstoque = scanner.nextInt();

        Produto novoProduto = new Produto(nome, descricao, categoria, preco, quantidadeEstoque);
        produtos.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void excluirProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.println("\n===== Excluir Produto =====");
        System.out.print("Digite o nome do produto a ser excluído: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.nome.equals(nome)) {
                produtos.remove(produto);
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    private static void consultarProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.println("\n===== Consultar Produto =====");
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.nome.equals(nome)) {
                exibirDetalhesProduto(produto);
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    private static void editarProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.println("\n===== Editar Produto =====");
        System.out.print("Digite o nome do produto a ser editado: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.nome.equals(nome)) {
                exibirDetalhesProduto(produto);

                System.out.print("Novo Nome: ");
                produto.nome = scanner.nextLine();

                System.out.print("Nova Descrição: ");
                produto.descricao = scanner.nextLine();

                System.out.print("Nova Categoria: ");
                produto.categoria = scanner.nextLine();

                System.out.print("Novo Preço: ");
                produto.preco = scanner.nextDouble();

                System.out.print("Nova Quantidade em Estoque: ");
                produto.quantidadeEstoque = scanner.nextInt();

                System.out.println("Produto editado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    private static void exibirDetalhesProduto(Produto produto) {
        System.out.println("Detalhes do Produto:");
        System.out.println("Nome: " + produto.nome);
        System.out.println("Descrição: " + produto.descricao);
        System.out.println("Categoria: " + produto.categoria);
        System.out.println("Preço: " + produto.preco);
        System.out.println("Quantidade em Estoque: " + produto.quantidadeEstoque);
    }
}