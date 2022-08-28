/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aseneg.mutante.repositorio;

import com.aseneg.mutante.entidad.MutanteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing.Arobles
 */
@Repository
public interface MutanteRepositorio extends JpaRepository<MutanteEntidad, Long> {

    @Query("SELECT COUNT(M.isMutante) AS texto FROM  MutanteEntidad AS M WHERE M.isMutante=true")
    public int countarMutantes();
    @Query("SELECT COUNT(M.isMutante) AS texto FROM  MutanteEntidad AS M WHERE M.isMutante=false")
    public int contarHumanos();

}
