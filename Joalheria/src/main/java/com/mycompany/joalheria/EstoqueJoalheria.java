package com.mycompany.joalheria;

// Classe principal para gerenciar o estoque da joalheria
import java.util.ArrayList;
import java.util.Scanner;

public class EstoqueJoalheria {
    public static void main(String[] args) {
        ArrayList<Joia> estoque = new ArrayList<>();

        // Adicionando joias específicas ao estoque inicial
        estoque.add(new Joia("Esmeralda", 2000.0, 7));
        estoque.add(new Joia("Rubi", 3000.0, 5));
        estoque.add(new Joia("Diamante", 10000.0, 3));
        estoque.add(new Joia("Ouro", 1500.0, 20));
        estoque.add(new Joia("Prata", 800.0, 15));

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            
            do {
                System.out.println("\n--- Gerenciamento de Estoque da Joalheria ---");
                System.out.println("1. Listar Joias");
                System.out.println("2. Adicionar Nova Joia");
                System.out.println("3. Realizar Venda");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1 -> {
                        System.out.println("\n--- Estoque Atual ---");
                        for (Joia joia : estoque) {
                            System.out.println(joia);
                        }
                    }
                    case 2 -> {
                        System.out.print("Nome da Joia: ");
                        scanner.nextLine(); // Limpar buffer
                        String nome = scanner.nextLine();
                        System.out.print("Preço: R$");
                        double preco = scanner.nextDouble();
                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();
                        estoque.add(new Joia(nome, preco, quantidade));
                        System.out.println("Nova joia adicionada ao estoque!");
                    }
                    case 3 -> {
                        System.out.println("\n--- Realizar Venda ---");
                        System.out.print("Nome da Joia: ");
                        scanner.nextLine(); // Limpar buffer
                        String nomeVenda = scanner.nextLine();
                        boolean encontrada = false;
                        for (Joia joia : estoque) {
                            if (joia.getNome().equalsIgnoreCase(nomeVenda)) {
                                System.out.print("Quantidade a vender: ");
                                int quantidadeVenda = scanner.nextInt();
                                joia.vender(quantidadeVenda);
                                encontrada = true;
                                break;
                            }
                        }
                        if (!encontrada) {
                            System.out.println("Joia não encontrada no estoque.");
                        }
                    }
                    case 4 -> System.out.println("Encerrando o programa. Até mais!");
                    default -> System.out.println("Opção inválida.");
                }
            } while (opcao != 4);
        }
    }
}