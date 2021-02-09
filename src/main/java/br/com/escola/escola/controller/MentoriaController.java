package br.com.escola.escola.controller;

import br.com.escola.escola.dto.MentoriaDTO;
import br.com.escola.escola.service.MentoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mentoria")
public class MentoriaController {

    @Autowired
    private MentoriaService mentoriaService;

    @GetMapping
    public ResponseEntity<List<MentoriaDTO>> getMentorias() {
        return new ResponseEntity<List<MentoriaDTO>>(mentoriaService.getMentorias(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentoriaDTO> getMentoria(@PathVariable("id") Long id) {
        return mentoriaService.getMentoriaById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity criaMentoria(@RequestBody MentoriaDTO mentoriaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mentoriaService.addMentoria(mentoriaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentoriaDTO> atualizaMentoria(@RequestBody MentoriaDTO mentoriaDTO, @PathVariable Long id) {
        return ResponseEntity.ok(mentoriaService.updateMentoria(mentoriaDTO, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletaMentoria(@PathVariable Long id) {
        mentoriaService.deletaMentoria(id);
    }
}

