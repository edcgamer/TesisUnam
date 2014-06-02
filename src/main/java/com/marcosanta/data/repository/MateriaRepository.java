/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marcosanta.data.repository;

import com.marcosanta.data.model.Materia;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Santa
 */
public interface MateriaRepository extends PagingAndSortingRepository<Materia, Integer>{
    @Override
    List<Materia> findAll();
    List<Materia> findByMateria(String materia);
}
