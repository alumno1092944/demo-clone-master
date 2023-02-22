package com.s2daw.demo.controllers;

import com.s2daw.demo.dao.UsuarioDao;
import com.s2daw.demo.models.Usuario;
import com.s2daw.demo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value="api/login",method= RequestMethod.POST)
    public Map loginUsuario(@RequestBody Usuario usuario){
        Map respuesta=new HashMap();
        Usuario usuarioLogueado=usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogueado!=null){
            // Si password es correcto, creo token y se lo paso
            String token=jwtUtil.create(String.valueOf(usuarioLogueado.getId()),
                    usuarioLogueado.getEmail());
            respuesta.put("token",token);
            respuesta.put("success","OK");
        }
        else respuesta.put("success","FAIL");
        return respuesta;
    }

}
