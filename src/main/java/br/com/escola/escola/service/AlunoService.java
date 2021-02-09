package br.com.escola.escola.service;

import br.com.escola.escola.dto.AlunoDTO;
import br.com.escola.escola.dto.NotaDTO;
import br.com.escola.escola.dto.ProgramaDTO;
import br.com.escola.escola.mapper.AlunoMapper;
import br.com.escola.escola.model.Aluno;
import br.com.escola.escola.model.Mentoria;
import br.com.escola.escola.model.Nota;
import br.com.escola.escola.repository.AlunoRepository;
import br.com.escola.escola.repository.MentoriaRepository;
import br.com.escola.escola.service.exception.ResourceNotFoundException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    AlunoMapper alunoMapper;

    @Autowired
    ProgramaService programaService;

    @Autowired
    MentoriaRepository mentoriaRepository;

    @Autowired
    NotaService notaService;

    public List<AlunoDTO> getAlunos() {
        return alunoRepository.findByActive(true)
                .stream()
                .map(alunoMapper::toAlunoDTO)
                .collect(Collectors.toList());
    }

    public Optional<AlunoDTO> getAlunoById(Long id) {
        return alunoRepository.findByIdAndActive(id, true)
                .map(alunoMapper::toAlunoDTO);
    }

    public AlunoDTO addAluno(AlunoDTO alunoDTO) throws NotFoundException {
        Optional<ProgramaDTO> programa = programaService.getProgramaById(alunoDTO.getPrograma().getId());
        if (programa.isEmpty()) {
            throw new NotFoundException("Programa não encontrado.");
        }
        Aluno aluno = alunoMapper.toAluno(alunoDTO);
        aluno.setActive(true);
        aluno.setPrograma(alunoDTO.getPrograma());
        return alunoMapper.toAlunoDTO(alunoRepository.save(aluno));
    }

    public AlunoDTO updateAluno(AlunoDTO alunoDTO, Long id) {
        Aluno alunoCadastrado = alunoRepository.findByIdAndActive(id, true)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        alunoCadastrado.setNome(alunoDTO.getNome());
        alunoCadastrado.setClasse(alunoDTO.getClasse());
        alunoCadastrado.setPrograma(alunoDTO.getPrograma());
        return alunoMapper.toAlunoDTO(alunoRepository.save(alunoCadastrado));
    }

    public void deleteAluno(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        aluno.setActive(false);
        aluno.getListaNotas().forEach(nota -> notaService.deleteNota(nota.getId()));
        alunoRepository.save(aluno);

        List<Mentoria> mentorias = (List<Mentoria>) mentoriaRepository.findByActive(true);
        mentorias.stream().filter(mentoria -> !mentoria.getAluno().getActive()).forEach(mentoria -> {
            mentoria.setActive(false);
            mentoriaRepository.save(mentoria);
        });

    }

    public AlunoDTO addNota(Long id, NotaDTO notaDTO) {
        Aluno aluno = alunoRepository.findByIdAndActive(id, true)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        aluno.getListaNotas().add(notaService.addNota(notaDTO));
        return alunoMapper.toAlunoDTO(alunoRepository.save(aluno));
    }

    public AlunoDTO updateNota(Long idAluno, Long idNota, NotaDTO notaDTO) {
        Aluno aluno = alunoRepository.findByIdAndActive(idAluno, true)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        Nota notaAluno = aluno.getListaNotas().get(idNota.intValue());
        notaService.updateNota(notaAluno.getId(), notaDTO);
        return alunoMapper.toAlunoDTO(aluno);
    }

    public void deleteNotaAluno(Long idAluno, Long idNota) {
        Aluno aluno = alunoRepository.findByIdAndActive(idAluno, true)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
        Nota notaAluno = aluno.getListaNotas().get(idNota.intValue());
        notaService.deleteNota(notaAluno.getId());
    }
}