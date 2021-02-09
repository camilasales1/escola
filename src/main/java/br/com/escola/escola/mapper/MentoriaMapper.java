package br.com.escola.escola.mapper;

import br.com.escola.escola.dto.MentoriaDTO;
import br.com.escola.escola.model.Mentoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MentoriaMapper {

    Mentoria toMentoria (MentoriaDTO mentoriaDTO);
    MentoriaDTO toMentoriaDTO(Mentoria mentoria);
}
