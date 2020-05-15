package com.leilao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeiloeiroTest {

    @Test
    public void testarMaiorLance() throws InvalidAttributeValueException {
        Leilao leilao = new Leilao();

        Usuario usuario = new Usuario("Daniel",1);
        Lance lance = new Lance(usuario, 2.0);

        Usuario usuario2 = new Usuario("Manuela",1);
        Lance lance2 = new Lance(usuario2, 1.0);

        List list   = new ArrayList(Arrays.asList(lance, lance2));
        leilao.setLances(list);
        Leiloeiro leiloeiro = new Leiloeiro("Cezar", leilao);

        Assertions.assertEquals(leiloeiro.maiorLance(), lance);
    }
    @Test
    public void testarMaiorLanceInvalido() throws InvalidAttributeValueException {
        Leilao leilao = new Leilao();

        List list   = new ArrayList();
        leilao.setLances(list);
        Leiloeiro leiloeiro = new Leiloeiro("Cezar", leilao);

        Assertions.assertEquals(leiloeiro.maiorLance(), null);
    }
}
