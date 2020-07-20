package br.com.fiap.rwsfiaplembretes.dto;

import br.com.fiap.rwsfiaplembretes.entity.Lembrete;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LembreteDTO {

    private Integer id;
    private String conteudo;

    @JsonProperty("prioridade")
    private PrioridadeEnum prioridadeEnum;

    public LembreteDTO() {
    }

    public LembreteDTO(Integer id, String conteudo, PrioridadeEnum prioridadeEnum) {
        this.id = id;
        this.conteudo = conteudo;
        this.prioridadeEnum = prioridadeEnum;
    }

    public LembreteDTO(Lembrete lembrete) {
        this.id = lembrete.getId();
        this.conteudo = lembrete.getConteudo();
        this.prioridadeEnum = lembrete.getPrioridadeEnum();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public PrioridadeEnum getPrioridadeEnum() {
        return prioridadeEnum;
    }

    public void setPrioridadeEnum(PrioridadeEnum prioridadeEnum) {
        this.prioridadeEnum = prioridadeEnum;
    }
}
