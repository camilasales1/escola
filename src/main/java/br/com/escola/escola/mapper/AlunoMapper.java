package br.com.escola.escola.mapper;

import br.com.escola.escola.dto.AlunoDTO;
import br.com.escola.escola.model.Aluno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    Aluno toAluno(AlunoDTO alunoDTO);
    AlunoDTO toAlunoDTO(Aluno aluno);
}
