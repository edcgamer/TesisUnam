/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.service.impl;

import com.marcosanta.controllers.RepositorioController;
import com.marcosanta.data.model.ObjetoAprendizaje;
import com.marcosanta.data.model.Referencia;
import com.marcosanta.data.repository.ObjetoAprendizajeRepository;
import com.marcosanta.data.repository.ReferenciaRepository;
import com.marcosanta.service.RepositorioService;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
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

    @Override
    public void saveReferencia(Referencia referencia) {
        referenciaRepository.save(referencia);
    }

    @Override
    public void guardaImagen(FileUploadEvent event, String path, String tipo,ObjetoAprendizaje oa) {
        try {
            String rutaTema = FacesContext.getCurrentInstance().getExternalContext().getRealPath(path);
            System.out.println(rutaTema + "/" + event.getFile().getFileName());
            FileOutputStream fileOuputStream
                    = new FileOutputStream(rutaTema + "/" + event.getFile().getFileName());
            fileOuputStream.write(event.getFile().getContents());
            fileOuputStream.close();
            Referencia referencia = new Referencia(tipo, path + "/" + event.getFile().getFileName(), event.getFile().getFileName().split("\\.")[0], true, oa);
            this.saveReferencia(referencia);
        } catch (Exception ex) {
            Logger.getLogger(RepositorioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Referencia> findBybjetoAprendizajeAndActivo(ObjetoAprendizaje objetoAprendizaje, boolean activo) {
        return referenciaRepository.findByObjetoAprendizajeAndActivo(objetoAprendizaje, activo);
    }
}
