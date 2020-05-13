package com.leilao;

public class Lance {
    private Usuario user;
    private double valor;

    public Lance() {
    }

    public Lance(Usuario user, double valor) {
        this.user = user;
        this.valor = valor;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
