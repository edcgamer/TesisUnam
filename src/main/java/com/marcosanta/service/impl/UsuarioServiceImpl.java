/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.service.impl;

import com.marcosanta.data.model.Usuario;
import com.marcosanta.data.repository.UsuarioRepository;
import com.marcosanta.service.UsuarioService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Santa
 */
public class UsuarioServiceImpl implements UsuarioService, Serializable {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
