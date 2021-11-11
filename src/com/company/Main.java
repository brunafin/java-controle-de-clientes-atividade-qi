package com.company;

import com.company.cliente.Cliente;

import java.util.Date;
import java.util.Scanner;

public class Main {


    public static void inicializar() {
        Scanner ler = new Scanner(System.in);
        Date dataEntrada = new Date();
        Cliente cliente = new Cliente();

        System.out.println("_______________________________________");
        System.out.println("Bem vindo - Vamos começar?");
        System.out.println("_______________________________________");
        System.out.println("Defina um tipo de cliente para abrir uma conta e poder comprar");
        System.out.println("A - Tipo 'A' - saldo inicial: R$ 10.000,00");
        System.out.println("B - Tipo 'B' - saldo inicial: R$ 5.000,00");
        System.out.println("C - Tipo 'C' - saldo inicial: R$ 1.000,00");

        System.out.println("\nEscolha uma opção do menu acima: ");
        String escolha = ler.nextLine();
        switch (escolha) {
            case "A":
            case "B":
            case "C":
                cliente.criarCliente(escolha, dataEntrada);
                break;
            default:
                System.out.println("Digite um tipo válido");
                break;
        }
    }

    public static void main(String[] args) {
        inicializar();
    }
}
