package com.company.cliente;

import com.company.contabancaria.ContaBancaria;

public class Cliente {
    // atributos da classe Cliente
    protected char tipo;
    protected double limite;
    protected int aumentoLimte;
    protected double bonus;
    protected int beneficioBonus;

    // construtor da classe Cliente
    public Cliente() {
    }

    // método criarCliente recebe um tipo nos parâmetros e troca o valor dos atributos conforme as regras de cada tipo
    public void criarCliente(char tipo) {
        setTipo(tipo);

        // aqui chama o toString
        System.out.println(this);

        // aqui cria a instância de um objeto da classe ContaBancária
        ContaBancaria novaConta = new ContaBancaria();
        switch (tipo) {
            case 'A':
                setLimite(10000);
                setAumentoLimte(500);
                setBonus(0.10);
                setBeneficioBonus(2);

                // aqui chama o método criarContaBancária passando nos argumentos os atributos que setamos de acordo com o tipo de cliente
                novaConta.criarContaBancaria(tipo, limite, aumentoLimte, bonus, beneficioBonus);
            case 'B':
                setLimite(5000);
                setAumentoLimte(0);
                setBonus(0.05);
                setBeneficioBonus(1);

                // aqui chama o método criarContaBancária passando nos argumentos os atributos que setamos de acordo com o tipo de cliente
                novaConta.criarContaBancaria(tipo, limite, aumentoLimte, bonus, beneficioBonus);
            case 'C':
                setLimite(1000);
                setAumentoLimte(0);
                setBonus(0);
                setBeneficioBonus(0);

                // aqui chama o método criarContaBancária passando nos argumentos os atributos que setamos de acordo com o tipo de cliente
                novaConta.criarContaBancaria(tipo, limite, aumentoLimte, bonus, beneficioBonus);
                break;
        }
    }

    // sets
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setAumentoLimte(int aumentoLimte) {
        this.aumentoLimte = aumentoLimte;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setBeneficioBonus(int beneficioBonus) {
        this.beneficioBonus = beneficioBonus;
    }

    // toString
    @Override
    public String toString() {
        return "____________________________________________________________________________________________________\n" +
                "Cliente criado com sucesso! \n" +
                "tipo: " + tipo + "\n" +
                "____________________________________________________________________________________________________";
    }
}
