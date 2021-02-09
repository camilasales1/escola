package br.com.escola.escola.repository;

import br.com.escola.escola.model.Aluno;
import br.com.escola.escola.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriaResitory extends JpaRepository<Materia, Long> {

    List<Materia> findByActive(Boolean active);
    Optional<Materia> findByIdAndActive(Long id, boolean active);
}
