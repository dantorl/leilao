package com.leilao;

import java.util.List;

public class Leiloeiro {
    private String nome;
    private Leilao leilao;

    public Leiloeiro() {
    }

    public Leiloeiro(String nome, Leilao leilao) {
        this.nome = nome;
        this.leilao = leilao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public Lance maiorLance(Leilao leilao) {
        List<Lance> lances = leilao.getLances();
        Lance retornaLance = new Lance();
        double maiorValor = 0;
        if (lances.isEmpty()){
            return null;
        }
        for (Lance lance: lances){
            if (lance.getValor() >= maiorValor){
                retornaLance = lance;
                maiorValor = lance.getValor();
            }
        }
        return retornaLance;
    }
}
