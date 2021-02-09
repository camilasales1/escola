package br.com.escola.escola.controller;

import br.com.escola.escola.dto.AlunoDTO;
import br.com.escola.escola.dto.NotaDTO;
import br.com.escola.escola.service.AlunoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Projeto Escola")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @ApiOperation(value = "Lista de Alunos")
    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAlunos() {
        return new ResponseEntity<List<AlunoDTO>>(alunoService.getAlunos(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna Aluno pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getAlunoById(@PathVariable("id") Long id) {
        return alunoService.getAlunoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Adiciona Aluno")
    @PostMapping
    public ResponseEntity addAluno(@RequestBody AlunoDTO alunoDTO) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.addAluno(alunoDTO));
    }

    @ApiOperation(value = "Atualiza Aluno")
    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> updateAluno(@RequestBody AlunoDTO alunoDTO, @PathVariable Long id) {
        return ResponseEntity.ok(alunoService.updateAluno(alunoDTO, id));
    }

    @ApiOperation(value = "Adiciona Nota para o  Aluno")
    @PutMapping("/{id}/nota")
    public AlunoDTO addNotaAluno(@RequestBody NotaDTO notaDTO, @PathVariable Long id) {
        return alunoService.addNota(id, notaDTO);
    }

    @ApiOperation(value = "Atualiza a Nota do Aluno")
    @PutMapping("/{id}/nota/{notaId}")
    public AlunoDTO updateNota(@RequestBody NotaDTO notaDTO, @PathVariable Long alunoId, @PathVariable Long notaId) {
        return alunoService.updateNota(alunoId, notaId, notaDTO);
    }

    @ApiOperation(value = "Deleta Aluno")
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
    }

    @ApiOperation(value = "Deleta Nota do Aluno")
    @DeleteMapping("/{aluno_id}/nota/{nota_id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteNotaAluno(@PathVariable Long alunoId, @PathVariable Long notaId) {
        alunoService.deleteNotaAluno(alunoId, notaId);
    }
}
