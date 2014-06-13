/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marcosanta.service.impl;

import com.marcosanta.data.model.ObjetoAprendizaje;
import com.marcosanta.data.model.Tema;
import com.marcosanta.data.repository.ObjetoAprendizajeRepository;
import com.marcosanta.data.repository.TemaRepository;
import com.marcosanta.service.ObjetoAprendizajeService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Santa
 */
public class ObjetoAprendizajeServiceImpl implements ObjetoAprendizajeService, Serializable{

    @Autowired
    private ObjetoAprendizajeRepository objetoAprendizajeRepository;
    
    @Autowired
    private TemaRepository temaRepository;
    
    @Override
    public void saveObjetoAprendizaje(ObjetoAprendizaje oa) {
        objetoAprendizajeRepository.save(oa);
    }

    @Override
    public void saveTema(Tema tema) {
        temaRepository.save(tema);
    }
    
}
