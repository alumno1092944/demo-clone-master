package com.s2daw.demo.controllers;

import com.s2daw.demo.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value="usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@hotmail.com");
        usuario.setTelefono("234234234");
        return usuario;
    }
    @RequestMapping(value="usuario")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@hotmail.com");
        usuario.setTelefono("234234234");
        return usuario;
    }
    @RequestMapping(value="usuario2")
    public Usuario eliminar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@hotmail.com");
        usuario.setTelefono("234234234");
        return usuario;
    }
    @RequestMapping(value="usuario3")
    public Usuario buscar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@hotmail.com");
        usuario.setTelefono("234234234");
        return usuario;
    }
}
