package br.com.escola.escola.service;

import br.com.escola.escola.dto.ProfessorDTO;
import br.com.escola.escola.mapper.ProfessorMapper;
import br.com.escola.escola.model.Mentoria;
import br.com.escola.escola.model.Professor;
import br.com.escola.escola.repository.MentoriaRepository;
import br.com.escola.escola.repository.ProfessorRepository;
import br.com.escola.escola.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    ProfessorMapper professorMapper;

    @Autowired
    MentoriaRepository mentoriaRepository;

    public List<ProfessorDTO> getProfessores() {
        return professorRepository.findAll()
                .stream()
                .map(professorMapper::toProfessorDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProfessorDTO> getProfessorById(Long id) {
        return professorRepository.findByIdAndActive(id, true).map(professorMapper::toProfessorDTO);
    }

    public ProfessorDTO addProfessor(ProfessorDTO professorDTO) {
        Professor professor = professorMapper.toProfessor(professorDTO);
        professor.setActive(true);
        return professorMapper.toProfessorDTO(professorRepository.save(professor));
    }

    public ProfessorDTO updateProfessor(ProfessorDTO mentorDTO, Long id) {
        Professor mentorCadastrado = professorRepository.findByIdAndActive(id, true)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor não encontrado"));
        mentorCadastrado.setNome(mentorDTO.getNome());
        mentorCadastrado.setPais(mentorDTO.getPais());
        return professorMapper.toProfessorDTO(professorRepository.save(mentorCadastrado));
    }

    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor não encontrado"));
        professor.setActive(false);
        professorRepository.save(professor);

        List<Mentoria> mentorias = (List<Mentoria>) mentoriaRepository.findByActive(true);
        mentorias.parallelStream().filter(mentoria -> !mentoria.getProfessor().getActive()).forEach(mentoria -> {
            mentoria.setActive(false);
            mentoriaRepository.save(mentoria);
        });
    }
}
