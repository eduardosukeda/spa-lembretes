package br.com.fiap.rwsfiaplembretes.controller;

import br.com.fiap.rwsfiaplembretes.dto.LembreteDTO;
import br.com.fiap.rwsfiaplembretes.service.LembreteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lembretes")
public class LembreteController {

    private LembreteService lembreteService;

    public LembreteController(LembreteService lembreteService) {
        this.lembreteService = lembreteService;
    }

    @GetMapping
    public ResponseEntity<List<LembreteDTO>> findAll() {
        return ResponseEntity.ok(lembreteService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<LembreteDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(lembreteService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<LembreteDTO> create(@RequestBody LembreteDTO lembreteDTO) {
        return ResponseEntity.ok(lembreteService.create(lembreteDTO));
    }

    @PutMapping
    public ResponseEntity<LembreteDTO> update(@RequestBody LembreteDTO lembreteDTO) {
        return ResponseEntity.ok(lembreteService.update(lembreteDTO));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        lembreteService.delete(id);
    }
}