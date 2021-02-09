package br.com.escola.escola.service;

import br.com.escola.escola.dto.MateriaDTO;
import br.com.escola.escola.mapper.MateriaMapper;
import br.com.escola.escola.model.Materia;
import br.com.escola.escola.repository.MateriaResitory;
import br.com.escola.escola.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MateriaService {

    @Autowired
    MateriaResitory materiaRepository;

    @Autowired
    MateriaMapper materiaMapper;

    public List<MateriaDTO> getMaterias() {
        return materiaRepository.findByActive(true)
                .stream()
                .map(materiaMapper::toMateriaDTO)
                .collect(Collectors.toList());
    }

    public Optional<MateriaDTO> getMateriaById(Long id) {
        return materiaRepository.findByIdAndActive(id, true)
                .map(materiaMapper::toMateriaDTO);
    }


    public MateriaDTO addMateria(MateriaDTO materiaDTO) {
        Materia materia = materiaMapper.toMateria(materiaDTO);
        materia.setActive(true);
        return materiaMapper.toMateriaDTO(materiaRepository.save(materia));
    }

    public MateriaDTO updateMateria(MateriaDTO materiaDTO, Long id) {
        Materia materiaCadastrada = materiaRepository.findByIdAndActive(id, true)
                .orElseThrow(() -> new ResourceNotFoundException("Matéria não encontrada."));
        materiaCadastrada.setNome(materiaDTO.getNome());
        return materiaMapper.toMateriaDTO(materiaRepository.save(materiaCadastrada));
    }

    public void deleteMateria(Long id) {
        Materia materia = materiaRepository.findByIdAndActive(id, true)
                .orElseThrow(() -> new ResourceNotFoundException("Matéria não encontrada."));
        materia.setActive(false);
        materiaRepository.save(materia);
    }
}
