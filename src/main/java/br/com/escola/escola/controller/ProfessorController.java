package br.com.escola.escola.controller;

import br.com.escola.escola.dto.ProfessorDTO;
import br.com.escola.escola.service.ProfessorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Projeto Escola")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @ApiOperation(value = "Lista de Professores")
    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> getMentores() {
        return new ResponseEntity<List<ProfessorDTO>>(professorService.getProfessores(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna Professor pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getMentor(@PathVariable("id") Long id) {
        return professorService.getProfessorById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Adiciona Professor")
    @PostMapping
    public ResponseEntity addMentor(@RequestBody ProfessorDTO professorDTO) {
        return ResponseEntity.ok(professorService.addProfessor(professorDTO));
    }

    @ApiOperation(value = "Atualiza Professor")
    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDTO> updateMentor(@RequestBody ProfessorDTO professorDTO, @PathVariable Long id) {
        return ResponseEntity.ok(professorService.updateProfessor(professorDTO, id));
    }

    @ApiOperation(value = "Deleta Professor")
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteMentor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }

}

