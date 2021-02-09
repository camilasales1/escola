package br.com.escola.escola.mapper;

import br.com.escola.escola.dto.MateriaDTO;
import br.com.escola.escola.model.Materia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MateriaMapper {

    Materia toMateria(MateriaDTO materiaDTO);
    MateriaDTO toMateriaDTO(Materia materia);
}
