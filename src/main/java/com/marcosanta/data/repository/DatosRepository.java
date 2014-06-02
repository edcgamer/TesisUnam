/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marcosanta.data.repository;

import com.marcosanta.data.model.Datos;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Santa
 */
public interface DatosRepository extends PagingAndSortingRepository<Datos, Integer> {
    
    List<Datos> findByDato(String dato);
    @Override
    List<Datos> findAll();
}
