package br.com.escola.escola.repository;

import br.com.escola.escola.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findByActive(Boolean active);
    Optional<Professor> findByIdAndActive(Long id, boolean active);

}
