package br.com.escola.escola.mapper;

import br.com.escola.escola.dto.ProgramaDTO;
import br.com.escola.escola.model.Programa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramaMapper {

    Programa toPrograma(ProgramaDTO programaDTO);
    ProgramaDTO toProgramaDTO(Programa programa);
}
