package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class SistemaProdutos {
    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Selecione a operação:");
            System.out.println("1. Criar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Consultar Produto");
            System.out.println("4. Editar Produto");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    criarProduto();
                    break;
                case 2:
                    excluirProduto();
                    break;
                case 3:
                    consultarProduto("ProdutoTeste");
                    break;
                case 4:
                    editarProduto();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void criarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite a descrição do produto:");
        String descricao = scanner.nextLine();

        System.out.println("Digite a categoria do produto:");
        String categoria = scanner.nextLine();

        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();

        System.out.println("Digite a quantidade em estoque do produto:");
        int quantidadeEstoque = scanner.nextInt();

        Produto produto = new Produto(nome, descricao, categoria, preco, quantidadeEstoque);
        produtos.add(produto);
        System.out.println("Produto criado com sucesso.");
    }

    public static void excluirProduto() {
        System.out.println("Digite o nome do produto que deseja excluir:");
        String nome = scanner.nextLine();

        boolean removido = false;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produtos.remove(produto);
                removido = true;
                System.out.println("Produto removido com sucesso.");
                break;
            }
        }

        if (!removido)
            System.out.println("Produto não encontrado.");
    }

    public static void consultarProduto(String produtoTeste) {
        System.out.println("Digite o nome do produto que deseja consultar:");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                System.out.println(produto);
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private static void editarProduto() {
        System.out.println("Digite o nome do produto que deseja editar:");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Digite o novo nome do produto:");
                produto.setNome(scanner.nextLine());

                System.out.println("Digite a nova descrição do produto:");
                produto.setDescricao(scanner.nextLine());

                System.out.println("Digite a nova categoria do produto:");
                produto.setCategoria(scanner.nextLine());

                System.out.println("Digite o novo preço do produto:");
                produto.setPreco(scanner.nextDouble());

                System.out.println("Digite a nova quantidade em estoque do produto:");
                produto.setQuantidadeEstoque(scanner.nextInt());

                System.out.println("Produto editado com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public void criarProduto(String produtoTeste, String descriçãoTeste, String categoriaTeste, double v, int i) {
    }

    public Collection<Object> getProdutos() {
        return null;
    }

    public void editarProduto(String produtoTeste, String novoNome, String novaDescrição, String novaCategoria, double v, int i) {
    }
}

