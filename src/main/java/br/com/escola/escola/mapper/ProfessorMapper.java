package br.com.escola.escola.mapper;

import br.com.escola.escola.dto.ProfessorDTO;
import br.com.escola.escola.model.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    Professor toProfessor(ProfessorDTO notaDTO);
    ProfessorDTO toProfessorDTO(Professor nota);
}
