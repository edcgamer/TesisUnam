/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.data.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "objetivo")
public class Objetivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "OBJETIVO")
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "IMPACTO")
    private Integer impacto;

    @JoinColumn(name = "OBJETO_APRENDIZAJE_ID", referencedColumnName = "ID")
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the impacto
     */
    public Integer getImpacto() {
        return impacto;
    }

    /**
     * @param impacto the impacto to set
     */
    public void setImpacto(Integer impacto) {
        this.impacto = impacto;
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

}
