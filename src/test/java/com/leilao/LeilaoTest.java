package com.leilao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeilaoTest {

    @Test
    public void testarNovoLance(){
        Usuario usuario = new Usuario("Daniel",1);

        Lance lance = new Lance(usuario, 2.0);

        Leilao leilao = new Leilao();
        Assertions.assertEquals(leilao.novoLance(lance), lance);
        Assertions.assertTrue(leilao.getLances().contains(lance));
    }
    @Test
    public void testarValidarLance(){
        Usuario usuario = new Usuario("Daniel", 1);
        Lance lance = new Lance(usuario, 1.5);

        Leilao leilao = new Leilao();

        Assertions.assertEquals(leilao.validarLance(lance), "Lance OK");
        leilao.novoLance(lance);

        Usuario usuario2 = new Usuario("Manuela", 2);
        Lance lance2 = new Lance(usuario2, 2.0);

        Assertions.assertEquals(leilao.validarLance(lance2), "Lance OK");
    }


}
