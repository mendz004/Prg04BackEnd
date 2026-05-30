package br.com.ifba.prg04backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPostRequestDto {

    @JsonProperty(value = "name")
    @NotNull(message = "Nome de usuário deve ser obrigatório!") // Nome não pode ser vazio
    private String name;

    @JsonProperty(value = "email")
    @NotNull(message = "Email de usuário deve ser obrigatório!") // E-mail não pode ser vazio
    @Email(message = "Insira um E-mail válido!") // Deve ter as caractéristicas do E-mail
    private String email;

    // Define que no JSON o atributo será chamado "password".
    @JsonProperty(value = "password")
    @NotNull(message = "Senha do usuário deve ser obrigatório!") // Senha nao pode ser vazia
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres!")
    private String password;
}
