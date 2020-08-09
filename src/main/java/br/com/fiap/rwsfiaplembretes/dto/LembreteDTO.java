package br.com.fiap.rwsfiaplembretes.dto;

import br.com.fiap.rwsfiaplembretes.entity.Lembrete;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LembreteDTO {

    private Integer id;
    private String conteudo;
    private String email;

    @JsonProperty("prioridade")
    private PrioridadeEnum prioridadeEnum;

    public LembreteDTO() {
    }

    public LembreteDTO(Integer id, String conteudo, String email, PrioridadeEnum prioridadeEnum) {
        this.id = id;
        this.conteudo = conteudo;
        this.email = email;
        this.prioridadeEnum = prioridadeEnum;
    }

    public LembreteDTO(Lembrete lembrete) {
        this.id = lembrete.getId();
        this.conteudo = lembrete.getConteudo();
        this.email = lembrete.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PrioridadeEnum getPrioridadeEnum() {
        return prioridadeEnum;
    }

    public void setPrioridadeEnum(PrioridadeEnum prioridadeEnum) {
        this.prioridadeEnum = prioridadeEnum;
    }
}
