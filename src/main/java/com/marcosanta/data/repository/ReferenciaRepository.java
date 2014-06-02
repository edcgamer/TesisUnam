/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marcosanta.data.repository;

import com.marcosanta.data.model.ObjetoAprendizaje;
import com.marcosanta.data.model.Referencia;
import com.marcosanta.data.model.Tema;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Santa
 */
public interface ReferenciaRepository extends PagingAndSortingRepository<Referencia, Integer>{
   @Override
   List<Referencia> findAll();
   List<Referencia> findByTipoAndObjetoAprendizaje(String tipo,ObjetoAprendizaje objetoAprendizaje);
}
