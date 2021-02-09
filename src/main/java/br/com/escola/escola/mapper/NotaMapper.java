package br.com.escola.escola.mapper;

import br.com.escola.escola.dto.NotaDTO;
import br.com.escola.escola.model.Nota;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotaMapper {

    Nota toNota(NotaDTO notaDTO);
    NotaDTO toNotaDTO(Nota nota);
}
