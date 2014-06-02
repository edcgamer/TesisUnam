/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marcosanta.data.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "referencia")
@XmlRootElement
public class Referencia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "TIPO")
    private String tipo;
    
    @Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "RUTA")
    private String ruta;
    
    @Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "TITULO")
    private String titulo;
    
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private boolean activo;
    
    @JoinColumn(name = "ID_OBJETO_APRENDIZAJE", referencedColumnName = "ID")
    @NotNull
    @ManyToOne(optional = false)
    private ObjetoAprendizaje objetoAprendizaje;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the objetoAprendizaje
     */
    public ObjetoAprendizaje getObjetoAprendizaje() {
        return objetoAprendizaje;
    }

    /**
     * @param objetoAprendizaje the objetoAprendizaje to set
     */
    public void setObjetoAprendizaje(ObjetoAprendizaje objetoAprendizaje) {
        this.objetoAprendizaje = objetoAprendizaje;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }


}
