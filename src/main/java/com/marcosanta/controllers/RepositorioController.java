/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcosanta.controllers;

import com.marcosanta.data.model.ObjetoAprendizaje;
import com.marcosanta.data.model.Referencia;
import com.marcosanta.service.RepositorioService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
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

    @PostConstruct
    public void init() {
        this.referenciasPdf = new ArrayList<>();
        this.referenciasPdf = new ArrayList<>();
        this.referenciasVideo = new ArrayList<>();
        this.objetosAprendizaje = this.repositorioService.findAll();
    }

    public void visualizarObjetoAprendizaje(ObjetoAprendizaje obj) {
        this.objetoAprendizaje = obj;
        this.referenciasImg = this.repositorioService.findByTipoAndObjetoAprendizaje("imagen", this.objetoAprendizaje);
        this.referenciasPdf = this.repositorioService.findByTipoAndObjetoAprendizaje("pdf", this.objetoAprendizaje);
        this.referenciasVideo = this.repositorioService.findByTipoAndObjetoAprendizaje("video", this.objetoAprendizaje);
    }

    public void handleFileUpload(FileUploadEvent event) {
        if (!event.getFile().getContentType().equals("")) {
            String[] array = event.getFile().getContentType().split("/");
            if (array.length > 1) {
                if (array[1].equals("pdf")) {

                    try {
                        // write the inputStream to a FileOutputStream
                        OutputStream outputStream;

                        outputStream = new FileOutputStream(new File("C:\\Users\\Santa\\Picturesed.pdf"));

                        int read = 0;
                        byte[] bytes = new byte[1024];
                        System.out.println("-----");
                        while ((read = event.getFile().getInputstream().read(bytes)) != -1) {
                            System.out.println("aaaaaaa");
                            outputStream.write(bytes, 0, read);
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(RepositorioController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (array[1].equals("png")) {

                }
            }
        }
//        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
//        FacesContext.getCurrentInstance().addMessage(null, message);
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

}
