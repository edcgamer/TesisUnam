/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marcosanta.service;

import com.marcosanta.data.model.ObjetoAprendizaje;
import com.marcosanta.data.model.Referencia;
import java.util.List;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Santa
 */
public interface RepositorioService {
    List<ObjetoAprendizaje> findAll();
    List<ObjetoAprendizaje> findByName(String name);
    List<Referencia> findByTipoAndObjetoAprendizaje(String tipo,ObjetoAprendizaje objetoAprendizaje);
    List<Referencia> findBybjetoAprendizajeAndActivo(ObjetoAprendizaje objetoAprendizaje,boolean activo);
    void saveReferencia(Referencia referencia);
    void guardaImagen(FileUploadEvent event, String path, String tipo,ObjetoAprendizaje oa);
}
