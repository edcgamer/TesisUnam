/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.service.impl;

import com.marcosanta.data.model.ObjetoAprendizaje;
import com.marcosanta.data.model.Referencia;
import com.marcosanta.data.repository.ObjetoAprendizajeRepository;
import com.marcosanta.data.repository.ReferenciaRepository;
import com.marcosanta.service.RepositorioService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Santa
 */
public class RepositorioServiceImpl implements RepositorioService, Serializable {

    @Autowired
    private ObjetoAprendizajeRepository objetoAprendizajeRepository;

    @Autowired
    private ReferenciaRepository referenciaRepository;

    @Override
    public List<ObjetoAprendizaje> findAll() {
        return objetoAprendizajeRepository.findAll();
    }

    @Override
    public List<ObjetoAprendizaje> findByName(String name) {
        return objetoAprendizajeRepository.findByNombre(name);
    }

    @Override
    public List<Referencia> findByTipoAndObjetoAprendizaje(String tipo, ObjetoAprendizaje objetoAprendizaje) {
        return referenciaRepository.findByTipoAndObjetoAprendizaje(tipo, objetoAprendizaje);
    }
}
