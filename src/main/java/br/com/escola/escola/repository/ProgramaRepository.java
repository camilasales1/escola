package br.com.escola.escola.repository;

import br.com.escola.escola.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Long> {

    List<Programa> findByActive(Boolean active);
    Optional<Programa> findByIdAndActive(Long id, boolean active);

}
