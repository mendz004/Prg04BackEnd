package br.com.ifba.prg04backend.model;

import br.com.ifba.prg04backend.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity //diz que essa claasse é uma tabela no BD
@Table(name = "usuarios") // nome da tabela
@Getter //metodos getters
@Setter //metodos setters
public class Usuario extends PersistenceEntity {


    //define a coluna na tabela
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

}
