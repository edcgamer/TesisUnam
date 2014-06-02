/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Santa
 */
@Controller("appCredentials")
@Scope("session")
public class AppCredentials implements Serializable {

    private static Pattern pattern = Pattern.compile("^([\\w\\dÁÉÍÓÚáéíóúñÑ:\\+\\- ]+)$");

    /**
     * @return the pattern
     */
    public static Pattern getPattern() {
        return pattern;
    }

    /**
     * @param aPattern the pattern to set
     */
    public static void setPattern(Pattern aPattern) {
        pattern = aPattern;
    }
    private SpringUser user;
    private Date fechaActual = new Date();
    private String idioma;

    public AppCredentials() {
    }

    /**
     * Valida que el usuario tenga permisos visualizar el contenido Inicializa
     * el intervalo y la query Obtiene la institucion con la que se esta
     * trabajando, si la institucion es DSA trae todas las instituciones
     * Reconoce el idioma que esta como activo en la vista
     */
    @PostConstruct
    public void init() {
        Authentication aut = SecurityContextHolder.getContext().getAuthentication();
        String usuario = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        user = (SpringUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        idioma = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(idioma));
    }

    /**
     *
     * @return SelectItem[] reconoce el idioma que esta como activo en la vista,
     * para usarlo tambien en la busqueda general
     */
    public static SelectItem[] obtenerIdiomas() {
        Locale local = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        SelectItem[] items = new SelectItem[2];
        switch (local.getLanguage()) {
            case "es":
                items[0] = new SelectItem("es", "Español");
                items[1] = new SelectItem("en", "English");
                break;
            case "en":
                items[0] = new SelectItem("en", "English");
                items[1] = new SelectItem("es", "Español");
                break;
        }
        return items;
    }

    public void cambiaLocal(ValueChangeEvent event) {
        idioma = event.getNewValue().toString();
    }

    /**
     * Cambia el idioma actual a Español (es)
     *
     */
    public void cambiaEs() {
        idioma = "es";
    }

    /**
     * Cambia el idioma actual por Inglés (en)
     */
    public void cambiaEn() {
        idioma = "en";
    }



    /**
     * Valida que el usuario con la secion activa tenga acceso a aeste módulo
     *
     * @return
     */
    public static void validaAcceso(Boolean acceso) {
        try {
            if (!acceso) {
                /* alternativa de uso para la redirección
                 FacesContext fc = FacesContext.getCurrentInstance();
                 ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication().getNavigationHandler();
                 nav.performNavigation("home");
                 */
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                String url = context.encodeActionURL(context.getRequestContextPath() + "/index.xhtml");
                context.redirect(url);
            }
        } catch (Exception ex) {
            Logger.getLogger(AppCredentials.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public SpringUser getUser() {
        return user;
    }

    public void setUser(SpringUser user) {
        this.user = user;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

}
