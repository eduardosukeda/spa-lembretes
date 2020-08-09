package br.com.fiap.rwsfiaplembretes.entity;

import br.com.fiap.rwsfiaplembretes.dto.LembreteDTO;
import br.com.fiap.rwsfiaplembretes.dto.PrioridadeEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_LEMBRETES")
public class Lembrete implements Serializable {

    private static final long serialVersionUID = 9100873854893361056L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CONTEUDO")
    private String conteudo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PRIORIDADE")
    private PrioridadeEnum prioridadeEnum;

    public Lembrete() {
    }

    public Lembrete(Integer id, String conteudo, String email, PrioridadeEnum prioridadeEnum) {
        this.id = id;
        this.conteudo = conteudo;
        this.email = email;
        this.prioridadeEnum = prioridadeEnum;
    }

    public Lembrete(LembreteDTO lembreteDTO) {
        this.id = lembreteDTO.getId();
        this.conteudo = lembreteDTO.getConteudo();
        this.prioridadeEnum = lembreteDTO.getPrioridadeEnum();
        this.email = lembreteDTO.getEmail();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
