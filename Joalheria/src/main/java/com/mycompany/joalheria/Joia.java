package com.mycompany.joalheria;

// Classe para representar uma joia
class Joia {
    private String nome;
    private double preco;
    private int quantidade;

    public Joia(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Reduzir a quantidade em estoque
    public void vender(int quantidadeVendida) {
        if (quantidadeVendida <= quantidade) {
            quantidade -= quantidadeVendida;
            System.out.println("Venda realizada: " + quantidadeVendida + " unidade(s) de " + nome);
        } else {
            System.out.println("Estoque insuficiente para a venda.");
        }
    }

    @Override
    public String toString() {
        return "Joia: " + nome + ", Preço: R$" + preco + ", Quantidade: " + quantidade;
    }
}