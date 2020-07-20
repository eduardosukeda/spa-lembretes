package br.com.fiap.rwsfiaplembretes.service;

import br.com.fiap.rwsfiaplembretes.dto.LembreteDTO;

import java.util.List;

public interface LembreteService {

    public List<LembreteDTO> findAll();

    public LembreteDTO findById(Integer id);

    public LembreteDTO create(LembreteDTO lembreteDTO);

    public LembreteDTO update(LembreteDTO lembreteDTO);

    public void delete(Integer id);
}
