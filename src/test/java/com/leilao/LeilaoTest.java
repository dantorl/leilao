package com.leilao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeilaoTest {

    @Test
    public void testarNovoLance() throws javax.management.InvalidAttributeValueException {
        Usuario usuario = new Usuario("Daniel",1);

        Lance lance = new Lance(usuario, 100);

        Leilao leilao = new Leilao();
        Assertions.assertEquals(leilao.novoLance(lance), lance);
        Assertions.assertTrue(leilao.getLances().contains(lance));
    }
    @Test
    public void testarNovoLanceVersaoViniErro(){
        Usuario usuario = new Usuario("Daniel",1);

        Lance lance = new Lance(usuario, 0);

        Leilao leilao = new Leilao();
        Assertions.assertThrows(InvalidAttributeValueException.class, () -> {leilao.novoLance(lance);} );
        //Assertions.assertEquals(leilao.novoLance(lance), lance);
        //Assertions.assertTrue(leilao.getLances().contains(lance));
    }

    @Test
    public void testarValidarLance() throws javax.management.InvalidAttributeValueException {
        Usuario usuario = new Usuario("Daniel", 1);
        Lance lance = new Lance(usuario, 100);

        Leilao leilao = new Leilao();

        Assertions.assertEquals(leilao.validarLance(lance), "Lance OK");
        leilao.novoLance(lance);

        Usuario usuario2 = new Usuario("Manuela", 2);
        Lance lance2 = new Lance(usuario2, 120);

        Assertions.assertEquals(leilao.validarLance(lance2), "Lance OK");
    }
    @Test
    public void testarValidarLanceVersaoVini(){
        Usuario usuario = new Usuario("Daniel", 1);
        Lance lance = new Lance(usuario, 100);
        List<Lance> lances = new ArrayList();

        Leilao leilao = new Leilao();
        leilao.setLances(lances);

        Assertions.assertEquals(leilao.validarLance(lance), "Lance OK");
    }
    @Test
    public void testarValidarLanceVersaoViniZeros(){
        Usuario usuario = new Usuario("Daniel", 1);
        Lance lance = new Lance(usuario, 0);
        List<Lance> lances = new ArrayList();

        Leilao leilao = new Leilao();
        leilao.setLances(lances);

        Assertions.assertEquals(leilao.validarLance(lance), "Favor enviar valor maior que zeros");
    }

    @Test
    public void testarValidarLanceVersaoViniMenorQueUltimoLance(){
        Usuario usuario = new Usuario("Daniel", 1);
        Lance lance = new Lance(usuario, 50);
        List<Lance> lances = new ArrayList(Arrays.asList(new Lance(usuario, 100)));

        Leilao leilao = new Leilao();
        leilao.setLances(lances);

        Assertions.assertEquals(leilao.validarLance(lance), "Favor enviar valor maior que o último Lance");
    }

}
