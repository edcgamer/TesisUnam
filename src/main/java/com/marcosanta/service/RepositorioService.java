/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marcosanta.service;

import com.marcosanta.data.model.ObjetoAprendizaje;
import com.marcosanta.data.model.Referencia;
import java.util.List;

/**
 *
 * @author Santa
 */
public interface RepositorioService {
    List<ObjetoAprendizaje> findAll();
    List<ObjetoAprendizaje> findByName(String name);
    List<Referencia> findByTipoAndObjetoAprendizaje(String tipo,ObjetoAprendizaje objetoAprendizaje);
}
