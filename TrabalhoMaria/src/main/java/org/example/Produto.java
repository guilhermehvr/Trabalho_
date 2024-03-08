package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    String descricao;
    String categoria;
    double preco;
    int quantidadeEstoque;

    public Produto(String nome, String descricao, String categoria, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }
}


