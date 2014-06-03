/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.controllers;

import com.marcosanta.data.model.ObjetoAprendizaje;
import com.marcosanta.data.model.Referencia;
import com.marcosanta.service.RepositorioService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Santa
 */
@Controller("repositorioController")
@Scope("session")
public class RepositorioController {

    @Autowired
    private RepositorioService repositorioService;

    private List<ObjetoAprendizaje> objetosAprendizaje;
    private ObjetoAprendizaje objetoAprendizaje;
    private List<Referencia> referenciasPdf;
    private List<Referencia> referenciasImg;
    private List<Referencia> referenciasVideo;
    private List<Referencia> referenciasInactivas;
    private StreamedContent file;

    @PostConstruct
    public void init() {
        file = null;
        this.referenciasInactivas = new ArrayList<>();
        this.referenciasPdf = new ArrayList<>();
        this.referenciasPdf = new ArrayList<>();
        this.referenciasVideo = new ArrayList<>();
        this.objetosAprendizaje = this.repositorioService.findAll();
    }

    public void actualizaReferencia(Referencia ref) {
        ref.setActivo(true);
        this.repositorioService.saveReferencia(ref);
        this.referenciasInactivas = this.repositorioService.findBybjetoAprendizajeAndActivo(this.objetoAprendizaje, false);
    }

    public void visualizarObjetoAprendizaje(ObjetoAprendizaje obj) {

        this.objetoAprendizaje = obj;
        this.referenciasInactivas = this.repositorioService.findBybjetoAprendizajeAndActivo(this.objetoAprendizaje, false);
        this.referenciasImg = this.repositorioService.findByTipoAndObjetoAprendizaje("imagen", this.objetoAprendizaje);
        this.referenciasPdf = this.repositorioService.findByTipoAndObjetoAprendizaje("pdf", this.objetoAprendizaje);
        this.referenciasVideo = this.repositorioService.findByTipoAndObjetoAprendizaje("video", this.objetoAprendizaje);
    }

    public void handleFileUpload(FileUploadEvent event) {
        if (!event.getFile().getContentType().equals("")) {
            String[] array = event.getFile().getContentType().split("/");
            if (array.length > 1) {
                System.out.println(array[1]);
                if (array[1].equals("pdf")) {
                    this.repositorioService.guardaImagen(event, "/resources/data/pdf", "pdf", this.objetoAprendizaje);
                } else if (array[1].equals("png")) {
                    this.repositorioService.guardaImagen(event, "/resources/data/imagen", "imagen", this.objetoAprendizaje);
                } else if (array[1].equals("jpg")) {
                    this.repositorioService.guardaImagen(event, "/resources/data/imagen", "imagen", this.objetoAprendizaje);
                } else if (array[1].equals("jpeg")) {
                    this.repositorioService.guardaImagen(event, "/resources/data/imagen", "imagen", this.objetoAprendizaje);
                }
            }
        }
    }

    public void verListaObjetosAprendizaje(ObjetoAprendizaje obj) {
        this.objetoAprendizaje = null;
    }

    public List<ObjetoAprendizaje> getObjetosAprendizaje() {
        return objetosAprendizaje;
    }

    /**
     * @param objetosAprendizaje the objetosAprendizaje to set
     */
    public void setObjetosAprendizaje(List<ObjetoAprendizaje> objetosAprendizaje) {
        this.objetosAprendizaje = objetosAprendizaje;
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
     * @return the referenciasPdf
     */
    public List<Referencia> getReferenciasPdf() {
        return referenciasPdf;
    }

    /**
     * @param referenciasPdf the referenciasPdf to set
     */
    public void setReferenciasPdf(List<Referencia> referenciasPdf) {
        this.referenciasPdf = referenciasPdf;
    }

    /**
     * @return the referenciasImg
     */
    public List<Referencia> getReferenciasImg() {
        return referenciasImg;
    }

    /**
     * @param referenciasImg the referenciasImg to set
     */
    public void setReferenciasImg(List<Referencia> referenciasImg) {
        this.referenciasImg = referenciasImg;
    }

    /**
     * @return the referenciasVideo
     */
    public List<Referencia> getReferenciasVideo() {
        return referenciasVideo;
    }

    /**
     * @param referenciasVideo the referenciasVideo to set
     */
    public void setReferenciasVideo(List<Referencia> referenciasVideo) {
        this.referenciasVideo = referenciasVideo;
    }

    /**
     * @return the referenciasInactivas
     */
    public List<Referencia> getReferenciasInactivas() {
        return referenciasInactivas;
    }

    /**
     * @param referenciasInactivas the referenciasInactivas to set
     */
    public void setReferenciasInactivas(List<Referencia> referenciasInactivas) {
        this.referenciasInactivas = referenciasInactivas;
    }

    /**
     * @return the file
     */
    public StreamedContent getFile() {
            InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/data/pdf/creditos.pdf");
            this.setFile(new DefaultStreamedContent(stream, "application/pdf", "caca.pdf"));
       
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(StreamedContent file) {
        this.file = file;
    }

}
