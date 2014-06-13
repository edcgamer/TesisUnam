/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.data.repository;

import com.marcosanta.data.model.Usuario;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;



/**
 *
 * @author Santa
 */
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {
    List<Usuario> findByCorreo(String correo);
    Usuario findByUsername(String username);
}
