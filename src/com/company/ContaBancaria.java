package com.company;


import java.util.Date;
import java.util.Scanner;

public class ContaBancaria extends Cliente {

    double saldoDevedor;
    double bonus;
    double accCompras;
    double accPagamentos;
    int beneficioBonus = 0;
    int direitoBonus;

    public ContaBancaria(){
    }

    public ContaBancaria(String tipo, double limite, int tipoAumentoLimite) {
        super(tipo, limite, tipoAumentoLimite);
        saldoDevedor = saldoDevedor;
        bonus = bonus; // percentual de desconto
        accCompras = accCompras;
        accPagamentos = accPagamentos;
        beneficioBonus = beneficioBonus; // quantidade de compras
        direitoBonus = direitoBonus; // cada vez que bater 2000 pagos precisa aumentar a quantidade que tem em beneficioBonus
    }

    Scanner ler = new Scanner(System.in);

    public ContaBancaria(String tipo, Date dataEntrada) {
        this.tipo = tipo;
        this.dataEntrada = dataEntrada;
    }

    public void criarContaBancaria(String tipo, double limite, int tipoAumentoLimite) {
        switch (tipo) {
            case "A":
                setLimite(limite);
                setTipoAumentoLimte(tipoAumentoLimite);
                setBonus(0.10);
                setBeneficioBonus(2);
                System.out.println(toString());
                acoesDaConta();
                break;
            case "B":
                setLimite(limite);
                setTipoAumentoLimte(tipoAumentoLimite);
                setBonus(0.05);
                setBeneficioBonus(1);
                System.out.println(toString());
                acoesDaConta();
                break;
            case "C":
                setLimite(limite);
                setTipoAumentoLimte(tipoAumentoLimite);
                System.out.println(toString());
                acoesDaConta();
                break;
        }
    }

    public void acoesDaConta() {
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
                                acoesDaConta();
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
                            pagar(valorAPagar);
                        } else {
                            System.out.println("----------------");
                            System.out.println("Não é possível realizar o pagamento, verifique seu limite ou se há valores em aberto");
                            System.out.println("----------------");
                            acoesDaConta();
                        }
                        break;
                    case 3:
                        System.out.println(toString());
                        acoesDaConta();
                    default:
                        System.out.println("Digite uma opção válida");
                        break;
                }
            }
        } while (escolha != 4);

    }

    public boolean verificaSaldo(double valorDaCompra) {
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

    public void verificaAumentoLimite() {
        if (accCompras >= 5000) {
            setLimite(limite + 500);
            setAccCompras(accCompras - 5000);
        }
    }

    public void verificaBonus(){
        if(accPagamentos >= 2000){
            setDireitoBonus(direitoBonus + beneficioBonus);
            setAccPagamentos(accPagamentos - 2000);
        }else if(accPagamentos < 2000){
            setDireitoBonus(0);
        }
    }

    public void comprar(double valor) {
        boolean aprovado = verificaSaldo(valor);
        if (aprovado) {
            if(direitoBonus > 0){
                System.out.println("Você tem direito a "+ bonus * 100 +"% de desconto nesta compra");
                setDireitoBonus(direitoBonus - 1);
                double valorComDesconto = valor - (valor * bonus);
                System.out.println("Valor com desconto: " + valorComDesconto);
                setSaldoDevedor(saldoDevedor + valorComDesconto);
                setLimite(limite - valorComDesconto);
                setAccCompras(accCompras + valorComDesconto);
                verificaAumentoLimite();
                System.out.println(toString());
            }else{
                System.out.println("Comprando... " + valor);
                setSaldoDevedor(saldoDevedor + valor);
                setLimite(limite - valor);
                setAccCompras(accCompras + valor);
                verificaAumentoLimite();
                System.out.println(toString());
            }
            return;
        }
        acoesDaConta();

    }

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
        verificaBonus();
        System.out.println(toString());
        acoesDaConta();
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
                "\nCliente: "+ tipo +
                "\nlimite: " + limite +
                "\nsaldo devedor: " + saldoDevedor +
                "\ntipo de bonus: " + bonus * 100 + "% de desconto nas próximas " + beneficioBonus + " compras a cada R$ 2.000,00 pagos" +
                "\ntotal de pagamentos realizados: " + accPagamentos +
                "\nbonus a resgatar: " + direitoBonus +
                "\n____________________________________________________________________________________________________";
    }
}
