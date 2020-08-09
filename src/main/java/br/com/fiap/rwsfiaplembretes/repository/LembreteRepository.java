package br.com.fiap.rwsfiaplembretes.repository;

import br.com.fiap.rwsfiaplembretes.entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Integer> {

    @Query(value = "select l from Lembrete l where l.email = :email")
    List<Lembrete> findAllByEmail(@Param("email") String email);
}