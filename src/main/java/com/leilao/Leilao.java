package com.leilao;

import ch.qos.logback.core.joran.conditional.IfAction;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;

public class Leilao {

    private List<Lance> lances = new ArrayList<>();

    public Leilao() {
    }

    public Leilao(List<Lance> lances) {
        this.lances = lances;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }

    public Lance novoLance(Lance lance) throws InvalidAttributeValueException {
        String validacaoLance = new String();
        validacaoLance = validarLance(lance);
        if (validacaoLance == "Lance OK"){
            this.lances.add(lance);
            return lance;
        }else {
           throw new InvalidAttributeValueException();
        }
    }

    public String validarLance(Lance lance) {
        //List<Lance> lances = getLances();
        if (lance.getValor() <= 0){
            return "Favor enviar valor maior que zeros";
         }
        if(this.lances.isEmpty()){
            return "Lance OK";
        }else{
            int index = this.lances.size() -1;
            double valorAtu = lance.getValor();
            Lance lanceUlt = this.lances.get(index);
            if (valorAtu <= lanceUlt.getValor()){
                return "Favor enviar valor maior que o último Lance";
            }else{
                return "Lance OK";
            }
        }

    }
}
