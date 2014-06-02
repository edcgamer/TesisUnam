/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.service;

import com.marcosanta.data.model.Usuario;



/**
 *
 * @author Santa
 */
public interface UsuarioService {

    /**
     * Obtiene un usuario de la base de datos
     *
     * @param usuario Usuario que debera obtener completamente de la base de
     * datos
     * @return Usuario encontrado
     */
    Usuario findUsuario(String username);
}
