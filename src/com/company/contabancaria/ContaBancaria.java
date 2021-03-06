package com.company.contabancaria;

import com.company.cliente.Cliente;

import java.util.Scanner;

    // conceito de herança aplicado onde ContaBancária é filha da classe Cliente
    // ContaBancária herda os atributos: tipo, limite, aumentoLimite, bonus e beneficioBonus da classe Cliente

public class ContaBancaria extends Cliente {
    private double saldoDevedor;
    private double accCompras;
    private double accPagamentos;
    private int direitoBonus;

    Scanner ler = new Scanner(System.in);

    // construtor
    public ContaBancaria() {
    }

    public void criarContaBancaria(char tipo, double limite, int aumentoLimite, double bonus, int beneficioBonus) {
        switch (tipo) {
            case 'A':
            case 'B':
            case 'C':
                setTipo(tipo);
                setLimite(limite);
                setAumentoLimte(aumentoLimite);
                setBonus(bonus);
                setBeneficioBonus(beneficioBonus);
                System.out.println(this);
                exibirAcoesDaConta();
                break;
        }
    }

    // ações da conta tem três opções: comprar, pagar e ver detalhes da conta
    public void exibirAcoesDaConta() {
        System.out.println("\n Escolha uma ação");
        System.out.println("1 - Comprar");
        System.out.println("2 - Pagar");
        System.out.println("3 - Ver detalhes da conta");
        int escolha = ler.nextInt();
        do {
            if (escolha != 4) {
                switch (escolha) {
                    case 1:
                        System.out.println("Mercadinho online - digite o número do item para comprá-lo");
                        System.out.println("1 - Item A - preço: R$ 500,00");
                        System.out.println("2 - Item B - preço: R$ 1000,00");
                        System.out.println("3 - Item C - preço: R$ 200,00");
                        System.out.println("4 - ir para ações da conta");
                        int opcao = ler.nextInt();
                        int valor = 0;
                        switch (opcao) {
                            case 1:
                                valor = 500;
                                comprar(valor);
                                break;
                            case 2:
                                valor = 1000;
                                comprar(valor);
                                break;
                            case 3:
                                valor = 200;
                                comprar(valor);
                                break;
                            case 4:
                                exibirAcoesDaConta();
                                break;
                            default:
                                System.out.println("Item não encontrado, escolha uma opção válida");
                                break;
                        }
                        break;
                    case 2:
                        if (saldoDevedor > 0 && limite > 0) {
                            System.out.println("Saldo devedor: " + saldoDevedor);
                            System.out.println("Quanto você deseja pagar?");
                            int valorAPagar = ler.nextInt();
                            if (valorAPagar <= saldoDevedor) {
                                pagar(valorAPagar);
                            } else {
                                System.out.println("Você não pode pagar um valor acima do saldo devedor");
                            }
                        } else {
                            System.out.println("----------------");
                            System.out.println("Não é possível realizar o pagamento, verifique seu limite ou se há valores em aberto");
                            System.out.println("----------------");
                            exibirAcoesDaConta();
                        }
                        break;
                    case 3:
                        System.out.println(this);
                        exibirAcoesDaConta();
                    default:
                        System.out.println("Digite uma opção válida");
                        break;
                }
            }
        } while (escolha != 4);

    }

    // verifica se o limite é maior que o valor da compra
    public boolean verificarSaldo(double valorDaCompra) {
        System.out.println("Verificando limite... ");
        if (valorDaCompra > limite) {
            System.out.println("-----ATENÇÃO----");
            System.out.println("Limite insuficiente!");
            System.out.println("----------------");
            return false;
        } else {
            return true;
        }

    }

    // verifica se atingiu a condição para aumentar o limite
    public void verificarAumentoLimite() {
        if (aumentoLimte > 0) {
            if (accCompras >= 5000) {
                setLimite(limite + 500);
                setAccCompras(accCompras - 5000);
            }
        }
    }

    // verifica se tem direito ao bonus
    public void verificarBonus() {
        if (bonus > 0) {
            if (accPagamentos >= 2000) {
                setDireitoBonus(direitoBonus + beneficioBonus);
                setAccPagamentos(accPagamentos - 2000);
            } else if (accPagamentos < 2000) {
                setDireitoBonus(0);
            }
        }
    }

    // permite usuário a fazer a compra
    public void comprar(double valor) {
        boolean aprovado = verificarSaldo(valor);
        if (aprovado) {
            if (direitoBonus > 0) {
                System.out.println("Você tem direito a " + bonus * 100 + "% de desconto nesta compra");
                setDireitoBonus(direitoBonus - 1);
                double valorComDesconto = valor - (valor * bonus);
                System.out.println("Valor com desconto: " + valorComDesconto);
                setSaldoDevedor(saldoDevedor + valorComDesconto);
                setLimite(limite - valorComDesconto);
                setAccCompras(accCompras + valorComDesconto);
                verificarAumentoLimite();
                System.out.println(this);
            } else {
                System.out.println("Comprando... " + valor);
                setSaldoDevedor(saldoDevedor + valor);
                setLimite(limite - valor);
                setAccCompras(accCompras + valor);
                verificarAumentoLimite();
                System.out.println(this);
            }
            return;
        }
        exibirAcoesDaConta();

    }

    // permite o usuário a pagar a conta digitando o valor que deseja pagar
    public void pagar(int valorAPagar) {
        System.out.println("Processando pagamento..." + valorAPagar);
        if (limite < valorAPagar) {
            System.out.println("-----ATENÇÃO----");
            System.out.println("Limite insuficiente!");
            System.out.println("valor disponível na conta: " + limite);
            System.out.println("----------------");
            return;
        }
        setSaldoDevedor(saldoDevedor - valorAPagar);
        setLimite(limite + valorAPagar);
        setAccPagamentos(accPagamentos + valorAPagar);
        verificarBonus();
        System.out.println(this);
        exibirAcoesDaConta();
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setBeneficioBonus(int beneficioBonus) {
        this.beneficioBonus = beneficioBonus;
    }

    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public void setAccCompras(double accCompras) {
        this.accCompras = accCompras;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setAccPagamentos(double accPagamentos) {
        this.accPagamentos = accPagamentos;
    }

    public void setDireitoBonus(int direitoBonus) {
        this.direitoBonus = direitoBonus;
    }


    @Override
    public String toString() {
        return "____________________________________________________________________________________________________\n" +
                "Detalhes da Conta Bancaria \n" +
                "\nCliente: " + tipo +
                "\nLimite: " + limite +
                "\nSaldo devedor: " + saldoDevedor +
                "\n\n---Regras de bonus--- " +
                "\nTipo de bonus: " + bonus * 100 + "% de desconto na(s) próxima(s) " + beneficioBonus + " compra(s) a cada R$ 2.000,00 pagos" +
                "\nTotal de pagamentos realizados para possível resgate de bonus: " + accPagamentos +
                "\nNúmero de compras com direito ao bonus: " + direitoBonus +
                "\n____________________________________________________________________________________________________";
    }
}
