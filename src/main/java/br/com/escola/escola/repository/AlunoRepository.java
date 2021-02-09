package br.com.escola.escola.repository;

import br.com.escola.escola.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByActive(Boolean active);
    Optional<Aluno> findByIdAndActive(Long id, boolean active);
}
