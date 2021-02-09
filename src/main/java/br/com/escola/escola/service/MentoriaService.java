package br.com.escola.escola.service;

import br.com.escola.escola.dto.MentoriaDTO;
import br.com.escola.escola.mapper.MentoriaMapper;
import br.com.escola.escola.model.Mentoria;
import br.com.escola.escola.repository.MentoriaRepository;
import br.com.escola.escola.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentoriaService {

    @Autowired
    MentoriaRepository mentoriaRepository;

    @Autowired
    MentoriaMapper mentoriaMapper;

    public List<MentoriaDTO> getMentorias() {
        return mentoriaRepository.findAll()
                .stream()
                .map(mentoriaMapper::toMentoriaDTO)
                .collect(Collectors.toList());
    }

    public Optional<MentoriaDTO> getMentoriaById(Long id) {
        return mentoriaRepository.findByIdAndActive(id, true)
                .map(mentoriaMapper::toMentoriaDTO);
    }

    public MentoriaDTO addMentoria(MentoriaDTO mentoriaDTO) {
        Mentoria mentoria = mentoriaMapper.toMentoria(mentoriaDTO);
        mentoria.setActive(true);
        return mentoriaMapper.toMentoriaDTO(mentoriaRepository.save(mentoria));
    }

    public MentoriaDTO updateMentoria(MentoriaDTO mentoriaDTO, Long id) {
        Mentoria mentoriaCadastrada = mentoriaRepository.findByIdAndActive(id, true)
                .orElseThrow(() -> new ResourceNotFoundException("Mentoria não encontrada"));
        mentoriaCadastrada.setAluno(mentoriaDTO.getAluno());
        mentoriaCadastrada.setProfessor(mentoriaDTO.getProfessor());
        return mentoriaMapper.toMentoriaDTO(mentoriaRepository.save(mentoriaCadastrada));
    }

    public void deletaMentoria(Long id) {
        Mentoria mentoria = mentoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mentoria não encontrada"));
        mentoria.setActive(false);
        mentoriaRepository.save(mentoria);
    }
}
