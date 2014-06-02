/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.controllers;

import com.marcosanta.data.model.Materia;
import com.marcosanta.data.model.ObjetoAprendizaje;
import com.marcosanta.data.model.Tema;
import com.marcosanta.data.repository.MateriaRepository;
import com.marcosanta.data.repository.ObjetoAprendizajeRepository;
import com.marcosanta.data.repository.TemaRepository;
import com.marcosanta.data.repository.UsuarioRepository;
import com.marcosanta.service.ObjetoAprendizajeService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Santa
 */
@Controller("objetoAprendizajeController")
@Scope("session")
public class ObjetoAprendizajeController {

    @Autowired
    private AppCredentials appCredentials;

    @Autowired
    private ObjetoAprendizajeService objetoAprendizajeService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private ObjetoAprendizajeRepository objetoAprendizajeRepository;

    @Autowired
    private TemaRepository temaRepository;

    private String materiaSeleccionada;
    private ObjetoAprendizaje objetoAprendizaje;
    private Tema tema;
    private List<Materia> materias;
    private List<Materia> materiasSeleccionadas;

    @PostConstruct
    public void init() {
        this.materias = materiaRepository.findAll();
        this.materiasSeleccionadas = new ArrayList<>();
        this.tema = new Tema();
        this.objetoAprendizaje = new ObjetoAprendizaje();
        if (this.materias.size() > 0) {
            this.materiaSeleccionada = this.materias.get(0).getMateria();
        }
    }
    
    public void saveObjetoAprendizaje() {
        objetoAprendizajeService.saveTema(this.tema);
        objetoAprendizaje.setUsuario(usuarioRepository.findByUsername(appCredentials.getUser().getUsername()));
        objetoAprendizaje.setListaMaterias(materiasSeleccionadas);
        objetoAprendizaje.setTema(this.temaRepository.findByTema(this.tema.getTema()).get(0));
        tema=new Tema();
        objetoAprendizajeService.saveObjetoAprendizaje(this.objetoAprendizaje);
        this.objetoAprendizaje= new ObjetoAprendizaje();
        this.materias= materiaRepository.findAll();
        this.materiasSeleccionadas = new ArrayList<>();
    }

    public void addMateria() {
        if (!this.materiaSeleccionada.equals("")) {
            Materia mat = materiaRepository.findByMateria(this.materiaSeleccionada).get(0);
            Materia materiaDummy = new Materia();
            if (mat != null) {
                this.materiasSeleccionadas.add(mat);
                for (Materia m : this.materias) {
                    if (mat.getMateria().equals(m.getMateria())) {
                        materiaDummy = m;
                        break;
                    }
                }
                this.materias.remove(materiaDummy);
            }
            if (this.materias.size() > 0) {
                this.materiaSeleccionada = this.materias.get(0).getMateria();
            } else {
                this.materiaSeleccionada = "";
            }
        }
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
     * @return the materiaSeleccionada
     */
    public String getMateriaSeleccionada() {
        return materiaSeleccionada;
    }

    /**
     * @param materiaSeleccionada the materiaSeleccionada to set
     */
    public void setMateriaSeleccionada(String materiaSeleccionada) {
        this.materiaSeleccionada = materiaSeleccionada;
    }

    /**
     * @return the materias
     */
    public List<Materia> getMaterias() {
        return materias;
    }

    /**
     * @param materias the materias to set
     */
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
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
     * @return the materiasSeleccionadas
     */
    public List<Materia> getMateriasSeleccionadas() {
        return materiasSeleccionadas;
    }

    /**
     * @param materiasSeleccionadas the materiasSeleccionadas to set
     */
    public void setMateriasSeleccionadas(List<Materia> materiasSeleccionadas) {
        this.materiasSeleccionadas = materiasSeleccionadas;
    }

}
