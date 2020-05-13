package com.leilao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeiloeiroTest {

    @Test
    public void testarMaiorLance(){
        Leilao leilao = new Leilao();
        Leiloeiro leiloeiro = new Leiloeiro();
        Usuario usuario = new Usuario("Daniel",1);
        Lance lance = new Lance(usuario, 2.0);

        leilao.novoLance(lance);

        Usuario usuario2 = new Usuario("Manuela",1);
        Lance lance2 = new Lance(usuario, 1.0);

        leilao.novoLance(lance2);

        Assertions.assertEquals(leiloeiro.maiorLance(leilao), lance);
    }
}
