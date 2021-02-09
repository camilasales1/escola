package br.com.escola.escola.service;

import br.com.escola.escola.dto.ProgramaDTO;
import br.com.escola.escola.mapper.ProgramaMapper;
import br.com.escola.escola.model.Programa;
import br.com.escola.escola.repository.ProgramaRepository;
import br.com.escola.escola.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgramaService {

    @Autowired
    ProgramaRepository programaRepository;

    @Autowired
    ProgramaMapper programaMapper;

    public List<ProgramaDTO> getProgramas() {
        return programaRepository.findAll()
                .stream()
                .map(programaMapper::toProgramaDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProgramaDTO> getProgramaById(Long id) {
        return programaRepository.findByIdAndActive(id, true)
                .map(programaMapper::toProgramaDTO);
    }

    public ProgramaDTO addPrograma(ProgramaDTO programaDTO) {
        Programa programa = programaMapper.toPrograma(programaDTO);
        programa.setActive(true);
        return programaMapper.toProgramaDTO(programaRepository.save(programa));
    }

    public ProgramaDTO updatePrograma(ProgramaDTO programaDTO, Long id) {
        Programa programaCadastrado = programaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Programa não encontrado"));
        programaCadastrado.setNome(programaDTO.getNome());
        programaCadastrado.setDataInicio(programaDTO.getDataInicio());
        programaCadastrado.setDataFim(programaDTO.getDataFim());
//        programaCadastrado.setAlunos((List<Aluno>) programaDTO.getAluno());
        return programaMapper.toProgramaDTO(programaRepository.save(programaCadastrado));
    }

    public void deletePrograma(Long id) {
        Programa programa = programaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Programa não encontrado"));
        programa.setActive(false);
        programaRepository.save(programa);
    }

}
