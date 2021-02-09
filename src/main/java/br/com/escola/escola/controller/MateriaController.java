package br.com.escola.escola.controller;

import br.com.escola.escola.dto.MateriaDTO;
import br.com.escola.escola.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    MateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<MateriaDTO>> getMaterias(){
        return new ResponseEntity<List<MateriaDTO>>(materiaService.getMaterias(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> getMateria(@PathVariable("id") Long id){
        return materiaService.getMateriaById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity addMateria(@RequestBody MateriaDTO materiaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaService.addMateria(materiaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaDTO> updateMateria(@RequestBody MateriaDTO materiaDTO, @PathVariable Long id){
        return ResponseEntity.ok(materiaService.updateMateria(materiaDTO, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteMateria(@PathVariable Long id){
        materiaService.deleteMateria(id);
    }

}
