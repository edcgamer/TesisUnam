/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.service.impl;

import com.marcosanta.data.repository.UsuarioRepository;
import com.marcosanta.service.CuentaUsuarioService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Santa
 */
public class CuentaUsuarioServiceImpl implements CuentaUsuarioService, Serializable {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public boolean validaExistenciaCorreo(String correo) {
        if (usuarioRepository.findByCorreo(correo).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
