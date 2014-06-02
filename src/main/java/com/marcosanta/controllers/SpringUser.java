

package com.marcosanta.controllers;

import com.marcosanta.data.model.Usuario;
import java.io.Serializable;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Santa
 */
public class SpringUser extends User implements Serializable{

    private Usuario usuario;

    public SpringUser(Usuario usuario, Collection<GrantedAuthority> authorities) {
        super(usuario.getUsername(), 
                usuario.getPassword(), 
                usuario.isEnabled(),  
                usuario.isEnabled(),
                usuario.isEnabled(), 
                usuario.isEnabled(), 
                authorities);
        this.usuario = usuario;
    }
    
    public SpringUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
