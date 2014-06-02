/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marcosanta.service;

import com.marcosanta.data.model.ObjetoAprendizaje;
import com.marcosanta.data.model.Tema;

/**
 *
 * @author Santa
 */
public interface ObjetoAprendizajeService {
    void saveObjetoAprendizaje(ObjetoAprendizaje oa);
    void saveTema(Tema tema);
}
