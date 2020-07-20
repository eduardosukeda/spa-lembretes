package br.com.fiap.rwsfiaplembretes.repository;

import br.com.fiap.rwsfiaplembretes.entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Integer> {
}