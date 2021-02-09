package br.com.escola.escola.controller;

import br.com.escola.escola.dto.ProgramaDTO;
import br.com.escola.escola.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    @GetMapping
    public ResponseEntity<List<ProgramaDTO>> getProgramas() {
        return new ResponseEntity<List<ProgramaDTO>>(programaService.getProgramas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaDTO> getPrograma(@PathVariable("id") Long id) {
        return programaService.getProgramaById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProgramaDTO> atualizaPrograma(@RequestBody ProgramaDTO programaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(programaService.addPrograma(programaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaDTO> atualizaPrograma(@RequestBody ProgramaDTO programaDTO, @PathVariable Long id) {
        return ResponseEntity.ok(programaService.updatePrograma(programaDTO, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletaAluno(@PathVariable Long id) {
        programaService.deletePrograma(id);
    }
}
