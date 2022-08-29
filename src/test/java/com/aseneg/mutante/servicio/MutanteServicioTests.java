/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aseneg.mutante.servicio;

import com.aseneg.mutante.entidad.MutanteEntidad;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Ing.Arobles
 */
@SpringBootTest
class MutanteServicioTests {

    @Autowired
    private MutanteServicio mutanteServicio;

    @Test
    void registrarAdnWhenMutanteEntidadThenRespondeMutanteNoNulo() {
        //Given 
        final MutanteEntidad mutante = new MutanteEntidad();
        mutante.setTexto("[ATGCGA, CAGTGC, TTATGT, AGAAGG, CCCCTA, TCACTG]");
        mutante.setMutante(true);
        // When
        MutanteEntidad mutanteEntidad = mutanteServicio.registrarAdn(mutante);
        // Then
        assertNotNull(mutanteEntidad);
    }

    @Test
    void countarMutantesWhenNoArgumentosThenListaNoNula() {
        // Given 
        int cantidadHumanos = mutanteServicio.countarMutantes();
        // Then
        assertNotNull(cantidadHumanos);
    }

    @Test
    void contarHumanosWhenNoArgumentosThenListaNoNula() {
        // Given 
        int cantidadMutantes = mutanteServicio.contarHumanos();
        // Then
        assertNotNull(cantidadMutantes);
    }
}
