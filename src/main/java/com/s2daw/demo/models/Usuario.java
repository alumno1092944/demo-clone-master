package com.s2daw.demo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ToString
@Table(name="usuarios")
@Entity
@Getter
@Setter
public class Usuario {
    @Column(name="id")
    @Id
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="email")
    private String email;
    @Column(name="telefono")
    private String telefono;
    @Column(name="password")
    private String password;

}
