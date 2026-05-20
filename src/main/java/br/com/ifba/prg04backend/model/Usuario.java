package br.com.ifba.prg04backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity //diz que essa claasse é uma tabela no BD
@Table(name = "usuarios") // nome da tabela
@Getter //metodos getters
@Setter //metodos setters
public class Usuario {

    @Id //primey key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //define a coluna na tabela
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

}
