package com.company;

import com.company.cliente.Cliente;

import java.util.Scanner;

public class Main {

    public static void inicializar() {
        // esse método exibe as opções de cliente com seus respectivos limites
        // o usuário digita a letra correspondente a opção que deseja (A, B ou C)
        Scanner ler = new Scanner(System.in);

        // aqui é feita a instância de um objeto cliente da classe Cliente
        Cliente cliente = new Cliente();

        System.out.println("_______________________________________");
        System.out.println("Bem vindo - Vamos começar?");
        System.out.println("_______________________________________");
        System.out.println("Defina um tipo de cliente para abrir uma conta e poder comprar");
        System.out.println("A - Tipo 'A' - saldo inicial: R$ 10.000,00");
        System.out.println("B - Tipo 'B' - saldo inicial: R$ 5.000,00");
        System.out.println("C - Tipo 'C' - saldo inicial: R$ 1.000,00");

        System.out.println("\nEscolha uma opção do menu acima: ");
        char tipo = ler.next().charAt(0);

        switch (tipo) {
            case 'A':
            case 'B':
            case 'C':
                // aqui chama o método criarCliente passando a letra da alternativa do tipo de cliente escolhido
                cliente.criarCliente(tipo);
                break;
            default:
                System.out.println("Digite um tipo válido");
                break;
        }
    }

    public static void main(String[] args) {
        // a partir do main é chamado o método inicializar que vai pedir para o cliente escolher um tipo de cliente para entrar
        inicializar();
    }
}
