package com.company;

import java.util.Date;
import java.util.Scanner;

public class Cliente {
    String tipo;
    Date dataEntrada;
    double limite;
    int tipoAumentoLimte;
    /*
    tipoAumentoLimite = 1 -> Reais
    tipoAumentoLimite = 2 -> %
    tipoAumentoLimite = 0 -> Não tem direito
    */

    public Cliente() {
    }

    public Cliente(String tipo, double limite, int tipoAumentoLimite) {
    }

    public void criarCliente(String tipo, Date hoje) {
        setTipo(tipo);
        setDataEntrada(hoje);
        System.out.println(toString());
        ContaBancaria novaConta = new ContaBancaria(tipo, dataEntrada);
        switch (tipo) {
            case "A":
                setLimite(10000);
                setTipoAumentoLimte(1);
                novaConta.criarContaBancaria(tipo, limite, tipoAumentoLimte);
            case "B":
                setLimite(5000);
                setTipoAumentoLimte(2);
                novaConta.criarContaBancaria(tipo, limite, tipoAumentoLimte);
            case "C":
                setLimite(1000);
                setTipoAumentoLimte(0);
                novaConta.criarContaBancaria(tipo, limite, tipoAumentoLimte);
                break;
        }
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setTipoAumentoLimte(int tipoAumentoLimte) {
        this.tipoAumentoLimte = tipoAumentoLimte;
    }

    @Override
    public String toString() {
        return "____________________________________________________________________________________________________\n" +
                "Cliente criado com sucesso! \n" +
                "tipo: " + tipo + "\n" +
                "data de entrada: " + dataEntrada + "\n" +
                "____________________________________________________________________________________________________";
    }
}
