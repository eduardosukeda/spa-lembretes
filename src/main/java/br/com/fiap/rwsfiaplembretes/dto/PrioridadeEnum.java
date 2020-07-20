package br.com.fiap.rwsfiaplembretes.dto;

public enum PrioridadeEnum {

    BAIXA("BAIXA"),
    MEDIA("MEDIA"),
    ALTA("ALTA");

    private final String prioridade;

    PrioridadeEnum(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getValor() {
        return prioridade;
    }
}
