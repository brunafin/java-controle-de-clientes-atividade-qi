package com.company.cliente;

import com.company.contabancaria.ContaBancaria;

import java.util.Date;

public class Cliente {
    protected String tipo;
    protected double limite;
    protected int aumentoLimte;
    protected double bonus;
    protected int beneficioBonus;

    public Cliente() {
    }

    public Cliente(String tipo, double limite, int aumentoLimite, double bonus, int beneficioBonus) {
    }

    public void criarCliente(String tipo) {
        setTipo(tipo);
        System.out.println(toString());
        ContaBancaria novaConta = new ContaBancaria(tipo);
        switch (tipo) {
            case "A":
                setLimite(10000);
                setAumentoLimte(500);
                setBonus(0.10);
                setBeneficioBonus(2);
                novaConta.criarContaBancaria(tipo, limite, aumentoLimte, bonus, beneficioBonus);
            case "B":
                setLimite(5000);
                setAumentoLimte(0);
                setBonus(0.05);
                setBeneficioBonus(1);
                novaConta.criarContaBancaria(tipo, limite, aumentoLimte, bonus, beneficioBonus);
            case "C":
                setLimite(1000);
                setAumentoLimte(0);
                setBonus(0);
                setBeneficioBonus(0);
                novaConta.criarContaBancaria(tipo, limite, aumentoLimte, bonus, beneficioBonus);
                break;
        }
    }

    public void setTipo(String tipo) {
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

    @Override
    public String toString() {
        return "____________________________________________________________________________________________________\n" +
                "Cliente criado com sucesso! \n" +
                "tipo: " + tipo + "\n" +
                "____________________________________________________________________________________________________";
    }
}
