/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.data.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Santa
 */
@Entity
@Table(name = "objeto_aprendizaje")
public class ObjetoAprendizaje implements Serializable {

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
    @Column(name = "NOMBRE")
    private String nombre;

    @ManyToMany
    @JoinTable(name = "objeto_aprendizaje_materia",
            joinColumns = {
                @JoinColumn(name = "objeto_aprendizaje_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "materia_id")})
    private List<Materia> listaMaterias;

    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    private Usuario usuario;

    @JoinColumn(name = "TEMA_ID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    private Tema tema;
    
    @JoinColumn(name = "TIPO_OBJETO_ID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    private TipoObjetoAprendizaje tipoObjetoAprendizaje;
    
    @OneToMany(targetEntity=com.marcosanta.data.model.Objetivo.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "OBJETO_APRENDIZAJE_ID")
    private List<Objetivo> objetivos;
    
    @OneToMany(targetEntity=com.marcosanta.data.model.Referencia.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_OBJETO_APRENDIZAJE")
    private List<Referencia> referencias;
    
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
     * @return the listaMaterias
     */
    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    /**
     * @param listaMaterias the listaMaterias to set
     */
    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the tema
     */
    public Tema getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(Tema tema) {
        this.tema = tema;
    }


    /**
     * @return the objetivos
     */
    public List<Objetivo> getObjetivos() {
        return objetivos;
    }

    /**
     * @param objetivos the objetivos to set
     */
    public void setObjetivos(List<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }

    /**
     * @return the referencias
     */
    public List<Referencia> getReferencias() {
        return referencias;
    }

    /**
     * @param referencias the referencias to set
     */
    public void setReferencias(List<Referencia> referencias) {
        this.referencias = referencias;
    }

    /**
     * @return the tipoObjetoAprendizaje
     */
    public TipoObjetoAprendizaje getTipoObjetoAprendizaje() {
        return tipoObjetoAprendizaje;
    }

    /**
     * @param tipoObjetoAprendizaje the tipoObjetoAprendizaje to set
     */
    public void setTipoObjetoAprendizaje(TipoObjetoAprendizaje tipoObjetoAprendizaje) {
        this.tipoObjetoAprendizaje = tipoObjetoAprendizaje;
    }



}
