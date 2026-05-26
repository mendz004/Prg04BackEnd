package br.com.ifba.prg04backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGetResponseDto {

    // Define que no JSON o atributo será chamado "name".
    @JsonProperty(value = "name")
    private String name;

    // Define que no JSON o atributo será chamado "email".
    @JsonProperty(value = "email")
    private String email;

}
