package com.marcosanta.controllers;

import com.marcosanta.data.model.Usuario;
import com.marcosanta.data.repository.UsuarioRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santa
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService,Serializable {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Usuario user;
        List<GrantedAuthority> autoridades = new ArrayList<GrantedAuthority>();
        user = usuarioRepository.findByUsername(username);
        if (user != null) {
           autoridades.add(new GrantedAuthorityImpl(user.getRol().getNombre()));
            return new SpringUser(username, user.getPassword(), true, true, true, true, autoridades);
        } else {
            throw new UsernameNotFoundException("User  no se encontro");
        }
    }
}
