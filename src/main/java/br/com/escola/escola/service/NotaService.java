package br.com.escola.escola.service;

import br.com.escola.escola.dto.NotaDTO;
import br.com.escola.escola.mapper.NotaMapper;
import br.com.escola.escola.model.Materia;
import br.com.escola.escola.model.Nota;
import br.com.escola.escola.repository.MateriaResitory;
import br.com.escola.escola.repository.NotaRepository;
import br.com.escola.escola.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaService {

    @Autowired
    NotaRepository notaRepository;

    @Autowired
    MateriaResitory materiaRepository;

    @Autowired
    NotaMapper notaMapper;

    public Nota addNota(NotaDTO notaDTO) {
        Materia materia = materiaRepository.findByIdAndActive(notaDTO.getMateria().getId(), true)
                .orElseThrow(() -> new ResourceNotFoundException("Mentoria não encontrada"));
        Nota nota = notaMapper.toNota(notaDTO);
        nota.setMateria(materia);
        return notaRepository.save(nota);
    }

    public NotaDTO updateNota(Long id, NotaDTO notaDTO) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota não encontrada"));
        nota.setNota(notaDTO.getNota());
        nota.setMateria(notaDTO.getMateria());
        nota.setData(notaDTO.getData());
        return notaMapper.toNotaDTO(notaRepository.save(nota));
    }

    public void deleteNota(Long id) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota não encontrada"));
        notaRepository.delete(nota);
    }
}
